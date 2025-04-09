
package control.logon;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import logon.LogonDBBean;
import logon.LogonDataBean;

@Controller
@RequestMapping("/logonchangepwd")
public class logonChange {
	@Resource
	private LogonDBBean logonDao;
	
	@GetMapping
	public String changePwdForm() throws Exception {
		return "member/changePwdForm";
	}
	
	@PostMapping
	public String changePwdPro(@ModelAttribute LogonDataBean logonDto, @RequestParam String userId, @RequestParam String passwd,
			@RequestParam String repasswd, Model model, HttpSession session ) throws Exception {		
		
		String email = (String) session.getAttribute("email");
		String Id = logonDao.findId(email);
		String Passwd = logonDao.findPasswd(userId);
		
	      if(!Id.equals(userId)) {
	    	  model.addAttribute("result", 0);
	      } else if(Passwd.equals(passwd)) {
	    	  model.addAttribute("result", 2);  
	      } else {
	    	  logonDao.changePasswd(logonDto);
	    	  model.addAttribute("result", 1);
	      }
	      	
	      return "member/changePwdPro";
		    
		}
} 







