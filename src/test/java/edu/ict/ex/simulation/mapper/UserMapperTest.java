package edu.ict.ex.simulation.mapper;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.simulation.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Disabled
	@Test
	void testUserMapper() {
		assertNotNull(userMapper);
	}
	
	@Test
	void testGetUser() {
		UserVO user = userMapper.getUser("user1");
		assertNotNull(user);
		
		System.out.println(user);
	}
	
	// 단방향(MD5,SHA등)은 암호화(encoding)는 가능해도 복호화(decoding)는 안되는 것을 말하고,
	// 양방향(AES,RSA,DES등)은 암호화 및 복호화가 가능한 것이다.
	
}
