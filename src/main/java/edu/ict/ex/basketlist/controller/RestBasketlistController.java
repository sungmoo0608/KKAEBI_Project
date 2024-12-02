package edu.ict.ex.basketlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.basketlist.service.BasketlistService;
import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("basketlistrest")
public class RestBasketlistController {

    @Autowired
    private BasketlistService basketlistService;

    //장바구니 조회 user_id 
    //basketlistrest/basketlist?user_id=user1 (user1 조회시)
    @GetMapping("/basketlist")
    public List<BasketlistVO> getBasketlistSummary(@RequestParam("user_id") String user_id) {
        return basketlistService.getBasketlistSummary(user_id);
    }

    //basketlistrest/basketlistdetail?user_id=user1&goods_gubun=1
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
}
