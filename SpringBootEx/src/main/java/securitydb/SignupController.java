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
@RequestMapping("/signup")
public class SignupController {
	@Resource
	UserMapper userMapper;	
		
	@Resource
	private PasswordEncoder passwordEncoder;
				
	@GetMapping
	public String form( Model model ) {		
		return "login/signup";
	}	
	
	@PostMapping
	public String pro( @ModelAttribute User user ) {
		user.setPasswd( passwordEncoder.encode( user.getPasswd() ) );
		user.setAuth( "ROLE_" + user.getAuth() );
		userMapper.insertUser( user );
		return "login/logon";
	}	
}