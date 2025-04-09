
package control.logon;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import logon.LogonDBBean;

@Controller
@RequestMapping
public class logonFind {
	@Resource
	private LogonDBBean logonDao;
	
	@GetMapping( "/logonfindid" )
	public String findIdForm() throws Exception {
		return "member/findIdForm";
	}
	
	@GetMapping( "/logonfindpwd" )
	public String findPwdForm() throws Exception {
		return "member/findPwdForm";
	}
	
	
	@PostMapping( "/logonfindid" )
	public String findIdPro( @RequestParam String email, Model model ) throws Exception {
		
		        String result = logonDao.findId(email);
		        model.addAttribute("result", result);		    
		        return "member/findIdPro";
		    
		}
} 