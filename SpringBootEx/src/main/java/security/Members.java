package security;


import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Members {
	// mb/members.xml과 연동 - member.xml과 큰 차이는 없지만 파일명 때문에 꼭 필요함(security가 해결 안된 상태라)
	private String userId;
	private String passwd;
	private String nickname;
	private String email;
	private Timestamp createdAt;
	private Timestamp deletedAt;
	private char blockId;
	private String auth;

}


// 자동 멤버로 가입이 되고
// 관리자인 경우 체크하세요. 확인 체크박스 