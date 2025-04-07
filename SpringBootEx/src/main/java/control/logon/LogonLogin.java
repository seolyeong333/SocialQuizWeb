package control.logon;
import mb.CreateBeans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import logon.LogonDBBean;

@Controller
@RequestMapping( "/logonlogin")
public class LogonLogin {

    private final CreateBeans createBeans;
	@Resource
	private LogonDBBean logonDao;

    LogonLogin(CreateBeans createBeans) {
        this.createBeans = createBeans;
    }
	
	@GetMapping
	public String loginForm() throws Exception {
		return "member/loginForm";
	}	
	
	@PostMapping
	public String loginPro( @RequestParam String user_id, @RequestParam String passwd,
		Model model, HttpSession session ) throws Exception {		
		System.out.println("안녕하세요");
		int result = logonDao.check( user_id, passwd );
		if( result == 1 )
			session.setAttribute( "memId", user_id );		
		model.addAttribute( "result", result );				
		return "member/loginPro";
	}
}









