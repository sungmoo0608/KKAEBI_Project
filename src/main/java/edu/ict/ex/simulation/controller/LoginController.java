package edu.ict.ex.simulation.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		
		log.info("login()..");

		return "login/login";
	}
	
	@GetMapping("/loginInfo")
	public String loginInfo(Authentication authentication,Principal principal,Model model) {
		
		log.info("loginInfo()..");
		
		//1. 방법
		if(principal != null) {
			System.out.println(principal);
			System.out.println(principal.getName());
			System.out.println(principal);
		}

		//2. 방법
		if(authentication != null) {
			System.out.println(authentication);
			System.out.println(authentication.getName());
			System.out.println(authentication.getAuthorities());
		}
		
		//3.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용할 수 있음)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		System.out.println(auth.getAuthorities());
		
		return "redirect:/";
	}
	
}
