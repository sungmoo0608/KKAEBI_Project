package edu.ict.ex.simulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.simulation.page.Criteria;
import edu.ict.ex.simulation.page.PageVO;
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
		
		log.info("getSavingProductList()..");
		
		model.addAttribute("getSavingProductList",savingProductService.getSavingProductList());
		
		return "savings/list";
	}
	
	// 페이징 설정된 리스트
	@GetMapping("/list2")
	public String list2(Criteria criteria, Model model) {
		log.info("list2().. ");
			
		model.addAttribute("getSavingProductList", savingProductService.getListWithPaging(criteria));
		int total = savingProductService.getTotal();
		model.addAttribute("pageMaker", new PageVO(criteria,total));
		
		return "savings/list2";
	}
	
	@GetMapping("/products_view")
	public String products_view(SavingProductVO savingProductVO,Model model) {
		
		log.info("products_view()..");
		
		model.addAttribute("products_view",savingProductService.get(savingProductVO.getFinprdtcd()));
		return "savings/products_view";
	}
	
}