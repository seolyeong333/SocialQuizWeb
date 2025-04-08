package logon;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Members {
	private String userId;
	private String passwd;
	private String nickname;
	private String auth;
	private String email;
	private Timestamp createdAt;
}


// 자동 멤버로 가입이 되고
// 관리자인 경우 체크하세요. 확인 체크박스 