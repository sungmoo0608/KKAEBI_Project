package edu.ict.ex.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.user.vo.UserVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface UserMapper  {
	
	UserVO getUser(String userid);
	
	@Insert("insert into customer_mas(user_id, passwd, cif_gubun, birthday, biz_no, name, telno, email, create_date, last_change_date) VALUES ( #{user_id}, #{passwd}, #{cif_gubun}, #{birthday}, #{biz_no}, #{name}, #{telno}, #{email}, #{create_date}, #{last_change_date} )")
	int insertUser(UserVO userVO);
	   
	@Insert("insert into authorities(user_id,authority) values(#{user_id},'ROLE_USER')")
	int insertAuthorities(UserVO userVO);	
	
}
