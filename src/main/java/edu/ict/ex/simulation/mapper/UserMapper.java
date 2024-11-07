package edu.ict.ex.simulation.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.simulation.vo.UserVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface UserMapper  {
	
	UserVO getUser(String userid);

	
}
