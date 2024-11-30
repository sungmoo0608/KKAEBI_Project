package edu.ict.ex.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.user.security.CustomUserDetailsService;
import edu.ict.ex.user.service.UserService;
import edu.ict.ex.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/auth") // API URL 경로 설정
public class RestLoginController {


	    @Autowired
	    private UserService userService;

	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	    // 회원가입 처리
	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody UserVO userVO) {
	        try {
	            userService.registerUser(userVO);
	            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed: " + e.getMessage());
	        }
	    }

	    // 로그인 처리 (Spring Security와 통합, 로그인은 기본적으로 formLogin()을 사용하지만, 로그인 상태 체크 API 제공)
	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginRequest) {
	        String username = loginRequest.get("userid");
	        String password = loginRequest.get("password");

	        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
	        if (userDetails != null && userService.passwordMatches(password, userDetails.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }

	    // 사용자 정보 조회
//	    @GetMapping("/info/{userid}")
//	    public ResponseEntity<UserVO> getUserInfo(@PathVariable("userid") String userid) {
//	        UserVO userVO = userService.getUserInfo(userid);
//	        if (userVO != null) {
//	            return ResponseEntity.ok(userVO);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }

	    // 사용자 정보 수정 (예시)
//	    @PutMapping("/update")
//	    public ResponseEntity<String> updateUser(@RequestBody UserVO userVO) {
//	        try {
//	            userService.updateUser(userVO);
//	            return ResponseEntity.ok("User updated successfully.");
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User update failed: " + e.getMessage());
//	        }
//	    }
	}
