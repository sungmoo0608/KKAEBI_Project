package edu.ict.ex.simulation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.ict.ex.simulation.mapper.UserMapper;
import edu.ict.ex.simulation.vo.UserVO;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserVO getUserById(String user_id) {
        UserVO user = userMapper.getUser(user_id);
       return user;
    }
}