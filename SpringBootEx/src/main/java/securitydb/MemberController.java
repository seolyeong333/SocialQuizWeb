package securitydb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping( "/member" )
public class MemberController {
	@GetMapping
	public String main( Model model ) {
		model.addAttribute( "result", "사용자페이지 입니다." );
		return "security/member";
	}	
}
