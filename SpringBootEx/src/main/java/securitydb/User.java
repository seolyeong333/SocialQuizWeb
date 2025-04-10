package securitydb;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
<<<<<<<< HEAD:SpringBootEx/src/main/java/securitydb/User.java
public class User {
========
public class LogonDataBean {
>>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7:SpringBootEx/src/main/java/logon/LogonDataBean.java
	private String userId;
	private String passwd;
	private String nickname;
	private String auth;
	private String email;
<<<<<<<< HEAD:SpringBootEx/src/main/java/securitydb/User.java
	private Timestamp createdAt;
	private Timestamp deletedAt;
	private char blockId;
	private String auth;
========
	private Timestamp created_at;
	private Timestamp deleted_at;
	private char blockId;

>>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7:SpringBootEx/src/main/java/logon/LogonDataBean.java
}
