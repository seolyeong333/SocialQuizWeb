package logon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages= { "mb", "logon", "control.logon" } )
@MapperScan( basePackages= { "logon" } )
public class SecurityDBApplication {
	public static void main(String[] args) {
		SpringApplication.run( SecurityDBApplication.class, args );
	}
}
