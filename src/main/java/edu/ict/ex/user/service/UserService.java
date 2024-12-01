package edu.ict.ex.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ict.ex.user.mapper.UserMapper;
import edu.ict.ex.user.vo.UserVO;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // 회원 정보 조회
    public UserVO getUserById(String userid) {
        UserVO user = userMapper.getUser(userid);
       return user;
    }
    
    // 회원 ID중복 체크
    public boolean isUserExists(String userid) {
        return userMapper.countUserById(userid) > 0;
    }
    
    // 회원 전화번호 중복 체크
    public boolean isUserPhoneExists(String telno) {
        return userMapper.countUserByPhone(telno) > 0; 
    }

    // 회원 이메일 중복 체크
    public boolean isUserEmailExists(String email) {
        return userMapper.countUserByEmail(email) > 0;
    }
    
    // 회원 사업자번호 중복 체크
    public boolean isUserBiznoExists(String bizno) {
        return userMapper.countUserByBizno(bizno) > 0;
    }
    
    // 비밀번호 매치
    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    
    // 회원가입 
    // 트랜잭션 관리
    @Transactional
    public void registerUser(UserVO userVO) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userVO.getPasswd());
        userVO.setPasswd(encodedPassword); // 암호화된 비밀번호 설정
        userMapper.insertUser(userVO);
        userMapper.insertAuthorities(userVO);
    }
    
}