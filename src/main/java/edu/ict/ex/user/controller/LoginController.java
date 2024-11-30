package edu.ict.ex.user.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class LoginController {
	
    @Autowired
    private HttpSession httpSession; // HttpSession 주입

	@GetMapping("/login1")
	public String login(Model model) {
		
		log.info("login()..");

		return "login/login";
	}
	
	@GetMapping("/loginInfo1")
	public String loginInfo(Authentication authentication,Principal principal,Model model) {
		
		log.info("loginInfo()..");
		
		//1. 방법
        if (principal != null) {
            log.info("Principal: " + principal.getName());
        }

		//2. 방법
        if (authentication != null) {
            log.info("Authenticated user: " + authentication.getName());
            log.info("Authorities: " + authentication.getAuthorities());
            
            // 로그인 성공 시 세션에 사용자 정보 저장
            httpSession.setAttribute("userid", authentication.getName());
            httpSession.setAttribute("authorities", authentication.getAuthorities());
        }
		
		//3.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용할 수 있음)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("SecurityContextHolder user: " + auth.getName());
        log.info("SecurityContextHolder authorities: " + auth.getAuthorities());
		
		return "redirect:/";
	}
	
}
