package edu.ict.ex.simulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.simulation.service.SavingProductService;
import edu.ict.ex.simulation.vo.SavingProductVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/savings")
public class SavingProductController {

	@Autowired
	private SavingProductService savingProductService; // FinProductService 주입
	
	@GetMapping("/list")
	public String list(Model model) {
		
		log.info("list()..");
		
		model.addAttribute("getSavingProductList",savingProductService.getSavingProductList());
		
		return "savings/list";
	}
	
	@GetMapping("/products_view")
	public String content_view(SavingProductVO savingProductVO,Model model) {
		
		log.info("products_view()..");
		
		model.addAttribute("products_view",savingProductService.get(savingProductVO.getFin_prdt_cd()));
		return "savings/products_view";
	}
	
	
}