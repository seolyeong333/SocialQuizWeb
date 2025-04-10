package securitydb;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.annotation.Resource;
@Controller
@RequestMapping( "/input" )
public class InputController {
	@Resource
	UserMapper mapper;	
		
	@Resource
	private PasswordEncoder passwordEncoder;
				
	@GetMapping
	public String form( Model model ) {		
		return "security/input";
	}	
	
	@PostMapping
	public String pro( @ModelAttribute User user ) {
		user.setPasswd( passwordEncoder.encode( user.getPasswd() ) );
		user.setAuth( "ROLE_" + user.getAuth() );
		mapper.insertUser( user );
		return "security/logon";
	}	
}