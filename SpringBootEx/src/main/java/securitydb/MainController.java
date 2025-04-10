package securitydb;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping( "/main" )
public class MainController {
	@GetMapping
	public String main( Model model, HttpSession session ) {
		String memId = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("memId", memId);
		model.addAttribute( "result", "메인페이지 입니다." );
		return "security/main";
	}	
}