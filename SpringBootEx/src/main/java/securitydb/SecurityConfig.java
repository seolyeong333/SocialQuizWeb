package securitydb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
<<<<<<<< HEAD:SpringBootEx/src/main/java/securitydb/SecurityConfig.java
=======
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
========
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

>>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7:SpringBootEx/src/main/java/security/SecurityConfig.java
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor()
public class SecurityConfig {
<<<<<<<< HEAD:SpringBootEx/src/main/java/securitydb/SecurityConfig.java
=======
@Configuration
@EnableWebSecurity
public class SecurityConfig {
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
	private final UserDetailsService userDetailsService;
  	public SecurityConfig( UserDetailsService userDetailsService ) {
      	this.userDetailsService = userDetailsService;
   	}	 
   	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration) 
		throws Exception {
      	return authenticationConfiguration.getAuthenticationManager();
    }  	
    
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring()
<<<<<<< HEAD
				.requestMatchers( "/static/board/**", "/static/logon/**", "/resources/**" );
=======
				.requestMatchers( "/static/board/**", "/static/logon/**" );
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
	}
	
	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {		
<<<<<<< HEAD
		
		http.csrf(
			AbstractHttpConfigurer::disable
		).authorizeHttpRequests(
			authz -> authz.requestMatchers( "/logon/**", "/input/**", "/security/**","main").permitAll()
					.requestMatchers( "/member/**").hasRole( "MEMBER" )
=======
		http.csrf(
			AbstractHttpConfigurer::disable
		).authorizeHttpRequests(
			authz -> authz.requestMatchers( "/logon/**", "/input/**", "/security/**" ).permitAll()
					.requestMatchers( "/member/**" ).hasRole( "MEMBER" )
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
					.requestMatchers( "/admin/**" ).hasRole( "ADMIN" )
					.anyRequest().authenticated()
		).httpBasic(
			Customizer.withDefaults()
		).formLogin(
			f -> f.loginPage( "/logon" )
<<<<<<< HEAD
				.usernameParameter( "userId" )
				.passwordParameter( "passwd" )
			    .successHandler(new SetLoginPage())
				//.defaultSuccessUrl( "/main", true )
=======
				.usernameParameter( "id" )
				.passwordParameter( "passwd" )
				.defaultSuccessUrl( "/main", true )
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
		).logout(
			f -> f.logoutUrl( "/logout" )
				.invalidateHttpSession( true )				// 세션무효화
				.deleteCookies( "JSESSIONID" )				// 쿠키 삭제
				.logoutSuccessUrl( "/logon" )
		);
		return http.build();
	}
<<<<<<< HEAD
}
========

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
>>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7:SpringBootEx/src/main/java/security/SecurityConfig.java
=======
}
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
