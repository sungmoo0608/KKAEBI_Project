package edu.ict.ex.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.goods.service.GoodsService;
import edu.ict.ex.goods.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j; 

@Slf4j
@Controller
@RequestMapping ("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;  

    //전체상품 목록
    @GetMapping("/list")
    public String list(Model model) {
    	log.info("list()..");
        model.addAttribute("goodsList", goodsService.getGoodsList());
        return "goods/list";    
    }
    
    //예금상품 목록
    @GetMapping("/Depositlist")
    public String depositlist(Model model) {
    	log.info("Depositlist()..");
        model.addAttribute("goodsList", goodsService.getDepositList());
        return "goods/listDeposit";    
    }
    
    //펀드상품 목록
    @GetMapping("/Fundlist")
    public String fundlist(Model model) {
    	log.info("Fundlist()..");
        model.addAttribute("goodsList", goodsService.getFundList());
        return "goods/listFund";    
    }
    
    //외환상품 목록
    @GetMapping("/Exchangelist")
    public String Exchangelist(Model model) {
    	log.info("Exchangelist()..");
        model.addAttribute("goodsList", goodsService.getExchangeList());
        return "goods/listExchange";    
    }
    
    //주식상품 목록
    @GetMapping("/Stocklist")
    public String Stocklist(Model model) {
    	log.info("Stocklist()..");
        model.addAttribute("goodsList", goodsService.getStockList());
        return "goods/listStock";    
    }
    
    //주식상품 목록
    @GetMapping("/Alllist")
    public String Alllist(Model model) {
    	log.info("Alllist()..");
        model.addAttribute("goodsList", goodsService.getAllList());
        return "goods/listStock";    
    }
    
    
    //상품 상세 보기
	//http://localhost:8282/goods/goods_view?goods_code=1000
	@GetMapping("/goods_view")
	public String goods_view(GoodsVO goodsVO,Model model) {
		
		log.info("goods_view()..");
		
		model.addAttribute("goods",goodsService.get(goodsVO.getGoods_code()));
		
		return "goods/detail";
	}
	
	//상품 추가 뷰페이지
	//http://localhost:8282/goods/create_view
	@GetMapping("/create_view")
	public String create_view() {
		
		log.info("create_view()..");

		return "goods/create";
	}
	
	//상품 추가 구현
	@PostMapping("/create")
	public String create(GoodsVO goodsVO) {
		
		log.info("create()..");
		
		goodsService.createGoods(goodsVO);
		
		return "redirect:/goods/list";
	}
	
	
	//상품 수정 뷰 페이지
	//http://localhost:8282/goods/edit?goods_code=1000
	@GetMapping("/edit")
	public String edit(GoodsVO goodsVO,Model model) {
		
		log.info("edit()..");
		
		model.addAttribute("goods",goodsService.get(goodsVO.getGoods_code()));
		
		return "goods/edit";
	}
	
	
	//상품 수정 구현
	@PostMapping("/modify")
	public String modify(GoodsVO goodsVO) {
		
		log.info("modify()..");
		
		goodsService.modifyGoods(goodsVO);
		
		return "redirect:/goods/list";
	}
	

	//상품 삭제 구현
	//http://localhost:8282/goods/delete
	@GetMapping("/delete")
	public String delete(GoodsVO goodsVO) {
		
		log.info("delete()..");
		
		int goodscode = goodsVO.getGoods_code();
		goodsService.delete(goodscode);
		
		return "redirect:/goods/list";
	}
	
	//상품 판매진행 미진행 구현
	//http://localhost:8282/goods/display
	@PostMapping("/display")
	public String display(GoodsVO goodsVO) {
		
		log.info("display()..");
		goodsService.display(goodsVO);
		
		return "redirect:/goods/list";
	}
	
}
    
    