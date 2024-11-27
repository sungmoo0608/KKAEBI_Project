package edu.ict.ex.transaction.controller;

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
import edu.ict.ex.performance.vo.PerformanceAllVO;
import edu.ict.ex.performance.vo.PerformanceCustomerDetailVO;
import edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO;
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
    	
    	int in_goods_gubun 		= Integer.parseInt(goods_gubun);
    	int in_goods_code 		= Integer.parseInt(goods_code);
    	double in_tr_number 	= Double.parseDouble(tr_number);
    	double in_tr_price 		= Double.parseDouble(tr_price);
    	double in_tr_amt 		= Double.parseDouble(tr_amt);
    	
        System.out.println(">>>>> getTransaction .... 1" + user_id + " - " + in_goods_gubun + " - " + in_goods_code + " - "
       		 + in_tr_number +  " - " + in_tr_price + " - " + in_tr_amt);

        System.out.println(">>>>> getTransaction .... 2");
    	TransactionVO transactionchk = transactionService.getTransactionCheckFetch(user_id,in_goods_code,in_tr_number,in_tr_price,in_tr_amt);
        System.out.println(">>>>> getTransaction .... 3 ");
        
        
        System.out.println(">>>>> getTransaction .... 3 ->>>> 1");
        
    	System.out.println(Double.valueOf(transactionchk.getTr_amt()));

        System.out.println(">>>>> getTransaction .... 3 ->>>> 2");
    	
        System.out.println(">>>>> getTransaction .... 4");

    	System.out.println(transactionchk);
        
        System.out.println(">>>>> getTransaction .... 5");
        
        // 화면에서 입력한 내용과 거래전 DB에서 점검한 결과를 비교
        
         
        // 상품매수 거래내역 INSERT 및 재조회
    	if (in_goods_gubun == 1)
    	{
            System.out.println(">>>>> getTransaction .... 7");
    		transactionService.createTransactionDeposit(transactionchk);
            System.out.println(">>>>> getTransaction .... 8");
    		
        	TransactionVO transaction = transactionService.getTransactionRecheckFetch(user_id,in_goods_code,in_tr_amt);
            model.addAttribute("transaction", transaction);
            System.out.println(">>>>> getTransaction .... 9");
            return "transaction/invest_deposit"; 
    	}
    	
    	// 펀드인 경우
    	else if (in_goods_gubun == 2)
    	{
            System.out.println(">>>>> getTransaction .... 7");
    		transactionService.createTransactionFund(transactionchk);
            System.out.println(">>>>> getTransaction .... 8");
    		
        	TransactionVO transaction = transactionService.getTransactionRecheckFetch(user_id,in_goods_code,in_tr_amt);
            model.addAttribute("transaction", transaction);
            System.out.println(">>>>> getTransaction .... 9");
            return "transaction/invest_fund"; 
    	}
    	// 외환인 경우
    	else if (in_goods_gubun == 3){
            System.out.println(">>>>> getTransaction .... 7");
    		transactionService.createTransactionExchange(transactionchk);
            System.out.println(">>>>> getTransaction .... 8");
    		
        	TransactionVO transaction = transactionService.getTransactionRecheckFetch(user_id,in_goods_code,in_tr_amt);
            model.addAttribute("transaction", transaction);
            System.out.println(">>>>> getTransaction .... 9");
            return "transaction/invest_exchange"; 
    	}
    	// 주식인 경우
    	else if (in_goods_gubun == 4){
            System.out.println(">>>>> getTransaction .... 7");
    		transactionService.createTransactionStock(transactionchk);
            System.out.println(">>>>> getTransaction .... 8");
    		
        	TransactionVO transaction = transactionService.getTransactionRecheckFetch(user_id,in_goods_code,in_tr_amt);
            model.addAttribute("transaction", transaction);
    		
            System.out.println(">>>>> getTransactionInit  --  invest_stock");
            return "transaction/invest_stock"; 
    	}
    	else {
            System.out.println(">>>>> getTransactionInit - anything" + goods_gubun);
        	return("");
    	}
    }
    
    
    
}
