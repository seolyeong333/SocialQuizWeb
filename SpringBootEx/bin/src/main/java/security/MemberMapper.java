package logon;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	// mb/members.xml 과 연동 - security로 따로 만들다가 들고온거라 저희의 member.xml과 크게 다르지는 않지만 이름 때문에 꼭 필요해서 넣어놓았어요
	public int insertMember( LogonDataBean dto );
	public int check( String userId );
	public int check( String userId, String passwd );
	public int checkNickname( String nickname );
	public int checkEmail( String email );
	public int deleteMember( String userId );
	public LogonDataBean getMember( String userId );
	public int modifyMember( LogonDataBean memberDto );
	
	Optional<Members> findByUserId( String userId );
}
