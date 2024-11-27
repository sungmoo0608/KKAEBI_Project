package edu.ict.ex.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/login")
	@ResponseBody
	public String MyAPI() {
		
		return "my route";
	}

}
