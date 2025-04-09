package logon;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import logon.LogonDataBean;
import security.Members;

@Mapper
public interface MemberMapper {
	public int insertMember( LogonDataBean dto );
	public int check( String userId );
	public int check( String userId, String passwd );
	public int checkNickname( String nickname );
	public int checkEmail( String email );
	public int deleteMember( String userId );
	public LogonDataBean getMember( String userId );
	public int modifyMember( LogonDataBean memberDto );
	
	public Optional<Members> findByUserId( String userId );
}
