package edu.ict.ex.simulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.ict.ex.simulation.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class UserController {
	
    @Autowired
    private UserService userService; // UserService 주입
    
}
