package edu.ict.ex.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.ict.ex.user.vo.UserVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface UserMapper  {
	
	UserVO getUser(String userid);
	
	//ID 중복 체크
    @Select("SELECT COUNT(*) FROM customer_mas WHERE user_id = #{userid}")
    int countUserById(String userid);
    
    //전화번호 중복 체크
    @Select("SELECT COUNT(*) FROM customer_mas WHERE telno = #{telno}")
    int countUserByPhone(String telno);
    
    //이메일 중복 체크
    @Select("SELECT COUNT(*) FROM customer_mas WHERE email = #{email}")
    int countUserByEmail(String email);
	
    //사업자 중복 체크
    @Select("SELECT COUNT(*) FROM customer_mas WHERE biz_no = #{biz_no}")
    int countUserByBizno(String bizno);
	
	//회원가입 
	@Insert("insert into customer_mas(user_id, passwd, cif_gubun, birthday, biz_no, name, telno, email, create_date, last_change_date) VALUES ( #{user_id}, #{passwd}, #{cif_gubun}, #{birthday}, #{biz_no}, #{name}, #{telno}, #{email}, TO_char(SYSDATE, 'YYYY-MM-DD'), TO_char(SYSDATE, 'YYYY-MM-DD') )")
	int insertUser(UserVO userVO);
	
	//회원가입 + 자동 유저권한 부여   
	@Insert("insert into authorities(user_id,authority) values(#{user_id},'ROLE_USER')")
	int insertAuthorities(UserVO userVO);	
	
}
