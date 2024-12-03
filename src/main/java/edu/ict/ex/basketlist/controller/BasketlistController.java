package edu.ict.ex.basketlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.basketlist.service.BasketlistService;
import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import edu.ict.ex.basketlist.vo.GoodsPriceVO;

 
@Controller
@RequestMapping("/basketlist")
public class BasketlistController {

    @Autowired
    private BasketlistService basketlistService;

    @GetMapping("/basketlist")
    public String getBasketlist(@RequestParam("user_id") String user_id, Model model) {

        List<BasketlistVO> basketlist = basketlistService.getBasketlistSummary(user_id);
        model.addAttribute("BasketlistSummaryList", basketlist);

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,"0");
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        return "basketlist/basketlist_list"; 
    }
    
    // 시장정보 상세조회[관리자용]
    @GetMapping("/basketlistdetail")
    public String getBasketlistDetail(@RequestParam("user_id") String user_id,@RequestParam("goods_gubun") String goods_gubun, Model model) {

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,goods_gubun);
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        return "basketlist/basketlistdet_list"; 
    }
    // 장바구니 삭제
    @GetMapping("/basketlistdelete")
    public String getBasketlistDelete(@RequestParam("user_id") String user_id,@RequestParam("seq_no") String seq_no, Model model) {

        basketlistService.deleteBasketlist(user_id,seq_no);

        List<BasketlistVO> basketlist = basketlistService.getBasketlistSummary(user_id);
        model.addAttribute("BasketlistSummaryList", basketlist);

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,"0");
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        return "basketlist/basketlist_list"; 
    }

    @GetMapping("/goodsprice_init")
    public String getGoodsPriceInit(@RequestParam("goods_gubun") String goods_gubun,
    								@RequestParam("goods_code") String goods_code, 
    								Model model) {
    	
    	int in_goods_gubun = Integer.parseInt(goods_gubun);
    	int in_goods_code = Integer.parseInt(goods_code);

        GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);

        model.addAttribute("goodsprice", goodsprice);

        // 예금상품인 경우 - 기등록된게 있으면 update 없으면 insert
    	if (in_goods_gubun == 1)
    	{
            return "basketlist/goodspriceinit_deposit"; 
        }
    	// 펀드인 경우 - 기등록된게 있으면 update 없으면 insert
    	else if (in_goods_gubun == 2){
            return "basketlist/goodspriceinit_fund"; 
    	}
    	// 외환인 경우 - 무조건 INSERT
    	else if (in_goods_gubun == 3){
            return "basketlist/goodspriceinit_exchange"; 
    	}
    	// 주식인 경우 - 무조건 INSERT
    	else if (in_goods_gubun == 4){
            return "basketlist/goodspriceinit_stock"; 
    	}
    	else {
        	return("");
    	}
    }
  
    //pricedeposot
    @GetMapping("/goodsprice")
    public String getGoodsPrice(@RequestParam("goods_gubun") String goods_gubun,
    							@RequestParam("goods_code") String goods_code, 
    							@RequestParam("tr_price") String tr_price, 
    							@RequestParam("job_gubun") String job_gubun, 
    							Model model) {

    	int in_goods_gubun 		= Integer.parseInt(goods_gubun);
    	int in_goods_code 		= Integer.parseInt(goods_code);
    	double in_tr_price 		= Double.parseDouble(tr_price);
    	int in_job_gubun 		= Integer.parseInt(job_gubun);
    	
        // 상품가격 등록
    	if (in_goods_gubun == 1)
    	{
            if (in_job_gubun == 1) {
            	basketlistService.createGoodsPriceDeposit(in_goods_gubun,in_goods_code,in_tr_price);
            }
            else {
            	basketlistService.updateGoodsPriceDeposit(in_goods_gubun,in_goods_code,in_tr_price);
            }
            GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            return "basketlist/goodsprice_deposit"; 
    	}
    	
    	// 펀드인 경우
    	else if (in_goods_gubun == 2)
    	{
            if (in_job_gubun == 1) {
            	basketlistService.createGoodsPriceFund(in_goods_gubun,in_goods_code,in_tr_price);
            }
            else {
            	basketlistService.updateGoodsPriceFund(in_goods_gubun,in_goods_code,in_tr_price); 
            }
            GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            return "basketlist/goodsprice_fund"; 
    	}
    	// 외환인 경우
    	else if (in_goods_gubun == 3){
        	basketlistService.createGoodsPriceExchange(in_goods_gubun,in_goods_code,in_tr_price);

            GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            return "basketlist/goodsprice_exchange"; 
    	}
    	// 주식인 경우
    	else if (in_goods_gubun == 4){
        	basketlistService.createGoodsPriceStock(in_goods_gubun,in_goods_code,in_tr_price);

            GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            return "basketlist/goodsprice_stock"; 
    	}
    	else {
            return " "; 
    	}
    	
    }
    
}
