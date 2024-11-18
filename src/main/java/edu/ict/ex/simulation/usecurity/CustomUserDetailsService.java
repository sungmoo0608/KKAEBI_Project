package edu.ict.ex.simulation.usecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ict.ex.simulation.mapper.UserMapper;
import edu.ict.ex.simulation.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

//알렉스 아저씨가 말하는 user 정보를 주고 받기 위한 Fax
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
	    
		log.warn("Load User By UserVO user : " + user_id);
		
		UserVO user = userMapper.getUser(user_id);
		
		log.warn("queried by UserVO mapper : " + user);
		
		return user == null? null:new UserDetailsVO(user);
		
	}
	
	
	
}
