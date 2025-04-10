package securitydb;

import org.springframework.security.core.userdetails.*;
<<<<<<< HEAD
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

=======
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
import java.util.Collections;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;
<<<<<<< HEAD

    public CustomUserDetailsService( UserMapper userMapper) {
        this.userMapper = userMapper;

    }
	
    @Override
    public UserDetails loadUserByUsername( String userId ) throws UsernameNotFoundException {	   
    	
       	User user = userMapper.findByUserId( userId ).orElseThrow(
			() -> new UsernameNotFoundException( "User not found" ));
       	
       	System.out.println("로그인 들어옴"+userId);


=======
    public CustomUserDetailsService( UserMapper userMapper ) {
        this.userMapper = userMapper;
    }
    @Override
    public UserDetails loadUserByUsername( String id ) throws UsernameNotFoundException {	    	
       	User user = userMapper.findByUserId( id ).orElseThrow(
			() -> new UsernameNotFoundException( "User not found" ) );
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
      	return new org.springframework.security.core.userdetails.User(
       		user.getUserId(), user.getPasswd(),
			Collections.singletonList( new SimpleGrantedAuthority( user.getAuth() ) )
      	);
<<<<<<< HEAD
  	}
=======
  	}	
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
}