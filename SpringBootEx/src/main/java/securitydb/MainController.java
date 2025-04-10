package securitydb;

<<<<<<< HEAD
import org.springframework.security.core.context.SecurityContextHolder;
=======
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD

import jakarta.servlet.http.HttpSession;
=======
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
@Controller
@RequestMapping( "/main" )
public class MainController {
	@GetMapping
<<<<<<< HEAD
	public String main( Model model, HttpSession session ) {
		String memId = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("memId", memId);
=======
	public String main( Model model ) {
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
		model.addAttribute( "result", "메인페이지 입니다." );
		return "security/main";
	}	
}