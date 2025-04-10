package security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import mb.MBApplication;

@SpringBootApplication
@ComponentScan( basePackages= { "mb", "logon", "control.","security" } )
@MapperScan( basePackages= { "logon", "security" } )
public class SecurityDBApplication {
	public static void main(String[] args) {
		SpringApplication.run( SecurityDBApplication.class, args );
	}
}
