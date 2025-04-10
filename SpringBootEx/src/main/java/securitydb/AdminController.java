package securitydb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping( "/admin" )
public class AdminController {
	@GetMapping
	public String main( Model model ) {
		model.addAttribute( "result", "관리자페이지 입니다." );
		return "security/admin";
	}	
}