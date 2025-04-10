package security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor()
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {	
		
		http.csrf( AbstractHttpConfigurer::disable );
		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers("/logon/**","/member/**",
						"/resources/**", "/static/board/**", 
						"/static/logon/**", "/static/images",
						"/logoninput").permitAll()
				.requestMatchers("/member/**", "/quiz/**").hasAuthority("ROLE_MEMBER")
				.anyRequest().authenticated()
		)
		.formLogin(
				login -> login.loginPage( "/logonlogin" )
					.usernameParameter( "userId" )
					.passwordParameter( "passwd")
				    .loginProcessingUrl("/logonmain")
				    .permitAll()

			)
		.logout(
				logout -> logout.logoutUrl( "/logonlogout" )
					.invalidateHttpSession( true )				// 세션무효화
					.deleteCookies( "JSESSIONID" )				// 쿠키 삭제
					.permitAll()
			);

		return http.build();
	}
	


}