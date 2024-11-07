package edu.ict.ex.simulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.simulation.service.FinProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/saving")
public class FinProductController {

	@Autowired
	private FinProductService finProductService; // FinProductService 주입
	
	@GetMapping("/list")
	public String list(Model model) {
		
		log.info("list()..");
		
		model.addAttribute("getFinProductOption",finProductService.getFinProductOption());
		
		return "saving/list";
	}

}