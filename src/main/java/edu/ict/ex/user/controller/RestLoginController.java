package edu.ict.ex.user.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.user.jwt.JwtTokenProvider;
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

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

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
	

    // 회원 ID 중복 체크
    @GetMapping("/check-id/{user_id}")
    public ResponseEntity<String> checkUserId(@PathVariable("user_id") String userid) {
        boolean exists = userService.isUserExists(userid);
        if (exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 등록된 ID 입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 ID 입니다.");
        }
    }

    // 회원 전화번호 중복 체크
    @GetMapping("/check-phone/{telno}")
    public ResponseEntity<String> checkUserPhone(@PathVariable("telno") String telno) {
        boolean exists = userService.isUserPhoneExists(telno);
        if (exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 등록된 전화번호 입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 전화번호 입니다.");
        }
    }

    // 회원 이메일 중복 체크
    @GetMapping("/check-email/{email}")
    public ResponseEntity<String> checkUserEmail(@PathVariable("email") String email) {
        boolean exists = userService.isUserEmailExists(email);
        if (exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 등록된 Email 입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 Email 입니다.");
        }
    }

    // 회원 사업자번호 중복 체크
    @GetMapping("/check-bizno/{bizno}")
    public ResponseEntity<String> checkUserBizno(@PathVariable("bizno") String bizno) {
        boolean exists = userService.isUserBiznoExists(bizno);
        if (exists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 등록된 사업자 번호 입니다.");
        } else {
            return ResponseEntity.ok("사용 가능한 사업자 번호 입니다.");
        }
    }

	// 로그인 처리 (Spring Security와 통합, 로그인은 기본적으로 formLogin()을 사용하지만, 로그인 상태 체크 API 제공)
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginRequest) {
		String userid = loginRequest.get("userid");
		String password = loginRequest.get("password");

		// CustomUserDetailsService로 사용자 정보 로드
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(userid);

		// 비밀번호가 맞는지 확인
		if (userDetails != null && userService.passwordMatches(password, userDetails.getPassword())) {
			// 로그인 성공 시 JWT 토큰 생성
			String token = jwtTokenProvider.createToken(userid, new ArrayList<>(userDetails.getAuthorities()));

			// JWT 토큰을 문자열 형태로 응답
	        return ResponseEntity.ok(token);  // ResponseEntity<String> 타입으로 반환
	    } else {
	        // 로그인 실패 시, 에러 메시지를 String 형태로 반환
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    }
	}

	// 사용자 정보 조회
	@GetMapping("/info/{userid}")
	public ResponseEntity<UserVO> getUserInfo(@PathVariable("userid") String userid) {
		UserVO userVO = userService.getUserById(userid);
		if (userVO != null) {
			return ResponseEntity.ok(userVO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

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
