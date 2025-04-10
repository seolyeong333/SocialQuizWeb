package securitydb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping( "/logon" )
public class LogonController {
	@GetMapping
	public String form( Model model ) {
		model.addAttribute( "result", "로그인페이지 입니다." );
		return "security/logon";
	}
}