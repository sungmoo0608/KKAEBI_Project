package edu.ict.ex.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.login.service.JWTRefreshService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RefreshController {
	
	 private final JWTRefreshService jwtRefreshService;

	    private Cookie createCookie(String key, String value) {

	        Cookie cookie = new Cookie(key, value);
	        cookie.setMaxAge(24*60*60);
//	        cookie.setSecure(true);
//	        cookie.setPath("/");
	        cookie.setHttpOnly(true);

	        return cookie;
	    }

	    @PostMapping("/refresh")
	    public ResponseEntity<?> tokenRefresh(HttpServletRequest request, HttpServletResponse response) {
	        String[] tokens = jwtRefreshService.refreshToken(request.getCookies());
	        if (tokens == null || tokens.length == 0) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        response.setHeader("authorization", tokens[0]);
	        response.addCookie(createCookie("refresh", tokens[1]));

	        return ResponseEntity.status(HttpStatus.OK).build();
	    }

}

