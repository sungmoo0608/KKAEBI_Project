package edu.ict.ex.user.mapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.ict.ex.user.vo.UserVO;
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

	@Disabled
	@Test
	void testGetUser() {
		UserVO user = userMapper.getUser("user1");
		assertNotNull(user);
		
		System.out.println(user);
	}
	
	// 단방향(MD5,SHA등)은 암호화(encoding)는 가능해도 복호화(decoding)는 안되는 것을 말하고,
	// 양방향(AES,RSA,DES등)은 암호화 및 복호화가 가능한 것이다.
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Disabled
	@Test
	void testInsertUser() {
		
		UserVO user = new UserVO();
		user.setUser_id("user77");
		user.setPasswd(passwordEncoder.encode("user77"));
		user.setCif_gubun("1");
		user.setBirthday("19901212");
		user.setBiz_no("");
		user.setName("테스트");
		user.setTelno("01011111111");
		user.setEmail("educenter@oraora.com");
		user.setCreate_date("20241130");
		user.setLast_change_date("");
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		
		assertNotNull(user);

		System.out.println(user);
	}
	
	@Disabled
	@Test
	void testMatcher() {
		
		UserVO user = userMapper.getUser("user1");
		//$2a$10$vLzYKr1RGSZ684fO4JESzukCGEUz6OJEcvAmwi06Krehcbry8L9zC
		boolean isMatch = passwordEncoder.matches("user1", user.getPasswd());
		
		System.out.println(user.getPasswd());
		assertEquals(isMatch, true);
		
		
	}
	

	
}
