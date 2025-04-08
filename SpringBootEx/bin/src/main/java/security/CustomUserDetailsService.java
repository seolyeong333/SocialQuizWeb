package logon;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberMapper memberMapper;
    public CustomUserDetailsService( MemberMapper memberMapper ) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername( String userId ) throws UsernameNotFoundException {	    	
       	Members members = memberMapper.findByUserId( userId ).orElseThrow(
			() -> new UsernameNotFoundException( "User not found" ) );
       	
       	System.out.println("✅ 로그인한 사용자 ID: " + members.getUserId());
       	System.out.println("✅ 권한 정보 (auth): " + members.getAuth());
       	
       	String role = members.getAuth();
        if (role == null || role.trim().isEmpty()) {
            throw new UsernameNotFoundException("권한 정보가 없습니다.");
        }

        return new org.springframework.security.core.userdetails.User(
                members.getUserId(),
                members.getPasswd(),
                List.of(new SimpleGrantedAuthority(role)) 
        );
  	}	
}