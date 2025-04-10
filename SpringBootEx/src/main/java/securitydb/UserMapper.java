package securitydb;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;
@Mapper
public interface UserMapper {    
	Optional<User> findByUserId( String id );
	int insertUser( User user );
}

