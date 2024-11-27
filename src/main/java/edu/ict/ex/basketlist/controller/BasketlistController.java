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

 
@Controller
@RequestMapping("/basketlist")
public class BasketlistController {

    @Autowired
    private BasketlistService basketlistService;

    @GetMapping("/basketlist")
    public String getBasketlist(@RequestParam("user_id") String user_id, Model model) {

        System.out.println(">>>>> getBasketlist  > >> 1");

        List<BasketlistVO> basketlist = basketlistService.getBasketlistSummary(user_id);
        model.addAttribute("BasketlistSummaryList", basketlist);

        System.out.println(">>>>> getBasketlist  > >> 2");

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,"0");
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        System.out.println(">>>>> getBasketlist  > >> 3");

        return "basketlist/basketlist_list"; 
    }
    
    // 시장정보 상세조회[관리자용]
    @GetMapping("/basketlistdetail")
    public String getBasketlistDetail(@RequestParam("user_id") String user_id,@RequestParam("goods_gubun") String goods_gubun, Model model) {

        System.out.println(">>>>> getBasketlistDetail  > >> 1");

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,goods_gubun);
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        System.out.println(">>>>> getBasketlistDetail  > >> 2");

        return "basketlist/basketlistdet_list"; 
    }
    // 장바구니 삭제
    @GetMapping("/basketlistdelete")
    public String getBasketlistDelete(@RequestParam("user_id") String user_id,@RequestParam("seq_no") String seq_no, Model model) {

        System.out.println(">>>>> getBasketlistDelete  > >> 0");

        basketlistService.deleteBasketlist(user_id,seq_no);

        System.out.println(">>>>> getBasketlistDelete  > >> 1");

        
        List<BasketlistVO> basketlist = basketlistService.getBasketlistSummary(user_id);
        model.addAttribute("BasketlistSummaryList", basketlist);

        System.out.println(">>>>> getBasketlistDelete  > >> 2");

        List<BasketlistDetailVO> basketlistdet = basketlistService.getBasketlistDetail(user_id,"0");
        model.addAttribute("BasketlistDetailList", basketlistdet);
 
        System.out.println(">>>>> getBasketlistDelete  > >> 3");

        return "basketlist/basketlist_list"; 
    }
    
}
