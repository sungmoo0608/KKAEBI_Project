package edu.ict.ex.simulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.simulation.page.Criteria;
import edu.ict.ex.simulation.page.PageVO;
import edu.ict.ex.simulation.service.SavingProductService;
import edu.ict.ex.simulation.vo.SavingProductPageVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/savingsrest")
public class RestSavingProductController {

	@Autowired
	private SavingProductService savingProductService; // FinProductService 주입
	
	@GetMapping("/list")
	public SavingProductPageVO list(Criteria criteria) {
		
		log.info("list() ..");
	      
		SavingProductPageVO vo = new SavingProductPageVO();
	      
		vo.setProduct(savingProductService.getListWithPaging(criteria));
	         
		int total = savingProductService.getTotal();
		vo.setPage(new PageVO(criteria,total));
	      
		return vo;
		
	}
	
}