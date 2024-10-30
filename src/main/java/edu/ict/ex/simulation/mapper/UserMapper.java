package edu.ict.ex.simulation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ict.ex.simulation.vo.UserVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface UserMapper  {
	
	UserVO getUser(String userid);

	@Select("SELECT * FROM users")
	List<UserVO> getAllUsers();
        
    @Select("SELECT COUNT(*) FROM users WHERE userid = #{userid}")
    int countUserById(String userid);
    
    @Select("SELECT COUNT(*) FROM users WHERE utel = #{utel}")
    int countUserByPhone(String utel);
    
    @Select("SELECT COUNT(*) FROM users WHERE uemail = #{uemail}")
    int countUserByEmail(String uemail);
    
	@Update("update users set password = #{password}, uname = #{uname}, utel = #{utel}, zipcode = #{zipcode}, uadr = #{uadr}, uadrdetail = #{uadrdetail}, uemail = #{uemail} WHERE userid = #{userid}")
	int modifyUser(UserVO userVO);
	
	@Insert("insert into users(userid, password, uname, utel, zipcode, uadr, uadrdetail, uemail) VALUES ( #{userid}, #{password}, #{uname}, #{utel}, #{zipcode}, #{uadr}, #{uadrdetail}, #{uemail} )")
	int insertUser(UserVO userVO);
	   
	@Insert("insert into authorities(userid,authority) values(#{userid},'ROLE_USER')")
	int insertAuthorities(UserVO userVO);	
	
    @Delete("DELETE FROM users WHERE userid = #{userid}")
    int deleteUser(String userid);
    
    @Delete("DELETE FROM authorities WHERE userid = #{userid}")
    int deleteAuthorities(String userid);
	
}
