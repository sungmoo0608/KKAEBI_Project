package edu.ict.ex.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;

import edu.ict.ex.login.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	 // 사용자 이름으로 사용자 정보 조회
    @Select("SELECT * FROM users WHERE username = #{username}")
    UserEntity findByUsername(String username);

    
}
