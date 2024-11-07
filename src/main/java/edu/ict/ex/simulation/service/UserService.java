package edu.ict.ex.simulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ict.ex.simulation.mapper.UserMapper;
import edu.ict.ex.simulation.vo.UserVO;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

}