package edu.ict.ex.login.service;

import org.springframework.security.core.userdetails.UserDetails;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.ict.ex.login.entity.UserEntity;
import edu.ict.ex.login.filter.CustomUserDetails;
import edu.ict.ex.login.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	 private final UserMapper userMapper;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        // MyBatis를 통해 사용자 정보를 조회
	        UserEntity userEntity = userMapper.findByUsername(username);
	        
	        if (userEntity == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }

	        // CustomUserDetails 객체로 변환하여 반환
	        return new CustomUserDetails(userEntity);
	    }

}
