package edu.ict.ex.basketlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.basketlist.service.BasketlistService;
import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import edu.ict.ex.basketlist.vo.GoodsPriceVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/basketlistrest")
public class RestBasketlistController {

    @Autowired
    private BasketlistService basketlistService;

    //장바구니 조회 user_id 
    //basketlistrest/basketlist?user_id=user1 (user1 조회시)
    @GetMapping("/basketlist")
    public List<BasketlistVO> getBasketlistSummary(@RequestParam("user_id") String user_id) {
        return basketlistService.getBasketlistSummary(user_id);
    }

    //ccc
    @GetMapping("/basketlistdetail")
    public List<BasketlistDetailVO> getBasketlistDetail(@RequestParam("user_id") String user_id,
                                                        @RequestParam("goods_gubun") String goods_gubun) {
        return basketlistService.getBasketlistDetail(user_id, goods_gubun);
    }
    
    //basketlistrest/basketlistdelete?user_id=user1&seq_no=1
    @PutMapping("/basketlistdelete")
    public void deleteBasketlistItem(@RequestParam("user_id") String user_id,
                                     @RequestParam("seq_no") String seq_no) {
        basketlistService.deleteBasketlist(user_id, seq_no);
    }
    
    //basketlistrest/basketlistinsert?user_id=user1&goods_code=1000
    @PutMapping("/basketlistinsert")
    public void insertBasketlistItem(@RequestParam("user_id") String user_id,
                                     @RequestParam("goods_code") String goods_code) {
        basketlistService.insertBasketlist(user_id, goods_code);
    }
    
    @GetMapping("/goodsprice_init")
    public GoodsPriceVO getGoodsPriceInit(@RequestParam("goods_gubun") String goods_gubun,
    								@RequestParam("goods_code") String goods_code) {
        
        // 'undefined' 값 처리
        if ("undefined".equals(goods_gubun) || "undefined".equals(goods_code)) {
            // 파라미터가 유효하지 않다는 메시지 출력
            System.out.println("잘못된 파라미터: goods_gubun 또는 goods_code 값이 undefined입니다.");
            return null; // 또는 적절한 에러 응답을 반환
        }
        
        int in_goods_gubun = Integer.parseInt(goods_gubun);
        int in_goods_code = Integer.parseInt(goods_code);

        GoodsPriceVO goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun, in_goods_code);
        
        if (goodsprice == null) {
            System.out.println("No data found for goods_gubun: " + goods_gubun + " and goods_code: " + goods_code);
            return null;  // 데이터를 찾을 수 없는 경우 null 반환
        }

        return goodsprice; // 데이터 반환 (자동으로 JSON으로 변환되어 반환됨)
    }

  
    //pricedeposot
    @GetMapping("/goodsprice")
    public GoodsPriceVO getGoodsPrice(@RequestParam("goods_gubun") String goods_gubun,
    							@RequestParam("goods_code") String goods_code, 
    							@RequestParam("tr_price") String tr_price, 
    							@RequestParam("job_gubun") String job_gubun, 
    							Model model) {

    	int in_goods_gubun 		= Integer.parseInt(goods_gubun);
    	int in_goods_code 		= Integer.parseInt(goods_code);
    	double in_tr_price 		= Double.parseDouble(tr_price);
    	int in_job_gubun 		= Integer.parseInt(job_gubun);
    	
    	GoodsPriceVO goodsprice = null;
    	
        // 상품가격 등록
    	if (in_goods_gubun == 1)
    	{
            if (in_job_gubun == 1) {
            	basketlistService.createGoodsPriceDeposit(in_goods_gubun,in_goods_code,in_tr_price);
            }
            else {
            	basketlistService.updateGoodsPriceDeposit(in_goods_gubun,in_goods_code,in_tr_price);
            }
            
            goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            //return "basketlist/goodsprice_deposit"; 
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
            goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            //return "basketlist/goodsprice_fund"; 
    	}
    	// 외환인 경우
    	else if (in_goods_gubun == 3){
        	basketlistService.createGoodsPriceExchange(in_goods_gubun,in_goods_code,in_tr_price);

            goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            //return "basketlist/goodsprice_exchange"; 
    	}
    	// 주식인 경우
    	else if (in_goods_gubun == 4){
        	basketlistService.createGoodsPriceStock(in_goods_gubun,in_goods_code,in_tr_price);

            goodsprice = basketlistService.getGoodsPriceInitFetch(in_goods_gubun,in_goods_code);
            model.addAttribute("goodsprice", goodsprice);

            //return "basketlist/goodsprice_stock"; 
    	}
    	else {
            //return " "; 
    	}
    	
    	return goodsprice;
    	
    	
    }
    
    
    
}
