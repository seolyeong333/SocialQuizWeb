package control.logon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logon.LogonDBBean;

@Service
@Controller

@RequestMapping
public class sendEmail {
	@Resource
	private LogonDBBean logonDao;
	
   @Autowired
	private JavaMailSender mailSender;
	
	private static String key;
	public void RandomKey(){
		key = Integer.toString( (int) Math.floor(Math.random()*90000)+10000);
	}
	
	@GetMapping("/sendmail")
	public String sendEmailForm() throws Exception {		
		return "mail/mailForm";
	}
	
	@PostMapping("/sendmail")
	@ResponseBody
	public String sendEmailPro( Model model, @RequestParam String email, @RequestParam(required = false) String emailVerified, 
			HttpSession session, HttpServletResponse response) {
		int checkemail = logonDao.checkEmail(email);
		if ("false".equals(emailVerified) && checkemail == 1) {
	        return "duplicate"; // 이메일 중복됨
	    }
		RandomKey();
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			message.setFrom("socialquizwebsite@gmail.com");
			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setSubject("소셜 퀴즈 웹사이트 이메일 인증");
			String text = "";
			text += "<h1>"+"인증코드 : "+"</h1><br>";
			text += "<h2>"+key+"</h2>";
			//System.out.println(key);
			message.setText(text,"UTF-8","html");
			
			mailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Mail Sent Successfully...");
		session.setAttribute("authKey",key);
        session.setAttribute("email", email);
		return "success";
	}
	
	@PostMapping("/sendmailcheck")
	@ResponseBody
	public Map<String, Object> sendEmailCheck(@RequestParam String emailAuth, HttpSession session) {
	    String storedKey = (String) session.getAttribute("authKey");
	    Map<String, Object> result = new HashMap<>();

	    if (storedKey != null && storedKey.equals(emailAuth.trim())) {
	        result.put("verified", true);
	    } else {
	        result.put("verified", false);
	    }

	    return result;
	}

	// 1. 인증 번호가 유효한 시간 설정이 되어있나요? - 즉 만료 되나요?  / ㅠㅠ 
 	// 2. 만약 메일이 오지 않았을 때 재전송 버튼 추가하면 좋을듯 ㅋㅋ 	/ ㅠㅠ
	// 선우팀 왔다감 ㅋㅋ
	// 잘 ~ 먹고 갑니다 ~ 니 코드 쩔더라
}
