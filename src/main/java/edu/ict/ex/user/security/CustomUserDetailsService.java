package edu.ict.ex.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ict.ex.user.mapper.UserMapper;
import edu.ict.ex.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

//알렉스 아저씨가 말하는 user 정보를 주고 받기 위한 Fax
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
	    
		log.warn("Load User By UserVO user : " + userid);
		
	    UserVO user = userMapper.getUser(userid);
	    
	    if (user == null) {
	        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
	    }
	    
	    log.warn("queried by UserVO mapper : " + user);
	    
	    return new UserDetailsVO(user);
		
	}	
	
}
