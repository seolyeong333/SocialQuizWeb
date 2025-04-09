package security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

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
		);
		
		http.formLogin(
				login -> login.loginPage( "/logonlogin" )
					.usernameParameter( "userId" )
					.passwordParameter( "passwd")
				    .loginProcessingUrl("/logonmain")
				    .successHandler(customLoginSuccessHandler)
				    .permitAll()

					//.failureHandler(loginfailurehandler())
					
					//.successHandler(null)
					//.successHandler() loadUserByUsername -> customuserdetail로 반환
					//success로 넘어간 다음 핸들러에서 세션 저장.
			);
		http.logout(
				logout -> logout.logoutUrl( "/logonlogout" )
				  //  .logoutSuccessHandler(customLogoutSuccessHandler)
					.invalidateHttpSession( true )				// 세션무효화
					.deleteCookies( "JSESSIONID" )				// 쿠키 삭제
					.permitAll()
			);
		 // session management
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );

        // entry point handler
       /* http.exceptionHandling(conf -> conf
                .authenticationEntryPoint(customAuthenticationEntryPointHandler)
                .accessDeniedHandler(customAccessDeniedHandler)
        );*/

		return http.build();
	}
	
	/* @Bean
	    public CustomAuthenticationProvider customAuthenticationProvider() {
	        return new CustomAuthenticationProvider(bCryptPasswordEncoder(), userGetService);
	    }

	    @Bean
	    public AuthenticationManager authenticationManager() {
	        CustomAuthenticationProvider authProvider = customAuthenticationProvider();
	        return new ProviderManager(authProvider);
	    }*/
		/*http.csrf(
			AbstractHttpConfigurer::disable
		).
		  .authorizeHttpRequests(
				authz -> authz.requestMatchers("/logon/**","/member/**","/resources/**", "/static/board/**", 
						"/static/logon/**", "/static/images",
						"/logoninput").permitAll()
			.requestMatchers( "/member/**" ,"/quiz/**" ).hasRole( "MEMBER" )
			.anyRequest().authenticated()
		).formLogin(
			f -> f.loginPage( "/logonlogin" )
			.loginProcessingUrl("/logonmain")
				.usernameParameter( "userId" )
				.passwordParameter( "passwd")
				.permitAll()
				//.successHandler() loadUserByUsername -> customuserdetail로 반환
				//success로 넘어간 다음 핸들러에서 세션 저장.
		).logout(
			f -> f.logoutUrl( "/logonlogout" )
				.invalidateHttpSession( true )				// 세션무효화
				.deleteCookies( "JSESSIONID" )				// 쿠키 삭제
				.logoutSuccessUrl( "/logonmain" )
				.permitAll()
		);
		*/


}