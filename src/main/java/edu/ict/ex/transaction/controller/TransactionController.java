package edu.ict.ex.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.transaction.service.TransactionService;
import edu.ict.ex.transaction.vo.TransactionVO;

 //
@Controller
@RequestMapping("/transaction") 
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // 상품투자 - 상품종류에 따른 투자를 위한 기본 정보 제공
	//         사용자정보,상품구분에 따른 투자화면,기본가격(이율/기준가/환율/주가
    @GetMapping("/invest_init")
    public String getTransactionInit(@RequestParam("user_id") String user_id,
    								@RequestParam("goods_gubun") String goods_gubun,
    								@RequestParam("goods_code") String goods_code, 
    								Model model) {
    	
        System.out.println(">>>>> getTransactionInit .... 1" + user_id + " - " + goods_gubun + " - " + goods_code);
    	int in_goods_gubun = Integer.parseInt(goods_gubun);
    	int in_goods_code = Integer.parseInt(goods_code);

        System.out.println(">>>>> getTransactionInit .... 2");
    	TransactionVO transaction = transactionService.getTransactionInitFetch(user_id,in_goods_code);
        System.out.println(">>>>> getTransactionInit .... 3");
        model.addAttribute("transaction", transaction);
        System.out.println(">>>>> getTransactionInit .... 4");

        // 예금상품인 경우
    	if (in_goods_gubun == 1)
    	{
            System.out.println(">>>>> getTransactionInit -- investinit_deposit");
            return "transaction/investinit_deposit"; 
        }
    	// 펀드인 경우
    	else if (in_goods_gubun == 2){
            System.out.println(">>>>> getTransactionInit -- investinit_fund");
            return "transaction/investinit_fund"; 
    	}
    	// 외환인 경우
    	else if (in_goods_gubun == 3){
            System.out.println(">>>>> getTransactionInit  -- investinit_exchange");
            return "transaction/investinit_exchange"; 
    	}
    	// 주식인 경우
    	else if (in_goods_gubun == 4){
            System.out.println(">>>>> getTransactionInit  --  investinit_stock");
            return "transaction/investinit_stock"; 
    	}
    	else {
            System.out.println(">>>>> getTransactionInit - anything" + goods_gubun);
        	return("");
    	}
    }
    
    @GetMapping("/invest")
    public String getTransaction(@RequestParam("user_id") String user_id,
    							@RequestParam("goods_gubun") String goods_gubun,
    							@RequestParam("goods_code") String goods_code, 
    							@RequestParam("tr_number") String tr_number, 
    							@RequestParam("tr_price") String tr_price, 
    							@RequestParam("tr_amt") String tr_amt, 
    							Model model) {
    	
        System.out.println(">>>>> getTransaction .... 1" + user_id + " - " + goods_gubun + " - " + goods_code
        		 + tr_number + " - " + tr_price + " - " + tr_amt);
    	int in_goods_gubun = Integer.parseInt(goods_gubun);
    	int in_goods_code = Integer.parseInt(goods_code);

        System.out.println(">>>>> getTransaction .... 2");
    	TransactionVO transaction = transactionService.getTransactionInitFetch(user_id,in_goods_code);
        System.out.println(">>>>> getTransaction .... 3");
        model.addAttribute("transaction", transaction);
        System.out.println(">>>>> getTransaction .... 4");

        // 예금상품인 경우
    	if (in_goods_gubun == 1)
    	{
            System.out.println(">>>>> getTransactionInit -- invest_deposit");
            return "transaction/invest_deposit"; 
        }
    	// 펀드인 경우
    	else if (in_goods_gubun == 2){
            System.out.println(">>>>> getTransactionInit -- invest_fund");
            return "transaction/invest_fund"; 
    	}
    	// 외환인 경우
    	else if (in_goods_gubun == 3){
            System.out.println(">>>>> getTransactionInit  -- invest_exchange");
            return "transaction/invest_exchange"; 
    	}
    	// 주식인 경우
    	else if (in_goods_gubun == 4){
            System.out.println(">>>>> getTransactionInit  --  invest_stock");
            return "transaction/invest_stock"; 
    	}
    	else {
            System.out.println(">>>>> getTransactionInit - anything" + goods_gubun);
        	return("");
    	}
    }
    
    
    
}
