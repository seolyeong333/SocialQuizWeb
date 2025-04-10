package security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages={ "mb", "logon", "board","qna","control.quiz",
		"control.oxgame","control.wordgame", "control.logon", 
		"control.board","control.qna", "websocket", "securitydb" } )
@MapperScan( basePackages= { "logon", "board", "qna", "quiz.oxgame","quiz.wordGame", "securitydb"} )
public class SecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run( SecurityApplication.class, args );
	}
}