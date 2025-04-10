package securitydb;

import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;
@Mapper
public interface UserMapper {    
<<<<<<< HEAD
	Optional<User> findByUserId( String userId );
=======
	Optional<User> findByUserId( String id );
>>>>>>> 94559a698e65f1ec2f19c305832979a4fe60f9d7
	int insertUser( User user );
}

