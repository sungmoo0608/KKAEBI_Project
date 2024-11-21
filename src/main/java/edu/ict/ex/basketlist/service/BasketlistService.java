package edu.ict.ex.basketlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ict.ex.basketlist.mapper.BasketlistMapper;
import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BasketlistService{
    
    private final BasketlistMapper basketlistMapper;
    
    public List<BasketlistVO> getBasketlistSummary(String user_id) {
    	
    	System.out.println(">>>getBasketlistSummary7 ===> [" + user_id + "] ");
    	
        return basketlistMapper.searchBasketlistSummaryList(user_id); // Mapper 메서드 호출
    }

    public List<BasketlistDetailVO> getBasketlistDetail(String user_id,String goods_gubun) {
    	
    	int in_goods_gubun = Integer.parseInt(goods_gubun);
    	int st_goods_gubun = 0;
    	int end_goods_gubun = 0;

    	if (in_goods_gubun > 0) {
    		st_goods_gubun = in_goods_gubun;
    		end_goods_gubun = in_goods_gubun;
    	} else  {
    		st_goods_gubun = 0;
    		end_goods_gubun = 9;
    	} 
    	System.out.println(">>>getBasketlistDetail ===> [" + goods_gubun + "]  [" + st_goods_gubun + "]  [" + end_goods_gubun+ "]  " );
    	
        return basketlistMapper.searchBasketlistDetailList(user_id,st_goods_gubun,end_goods_gubun); // Mapper 메서드 호출
    }

    
    
    

    public void deleteBasketlist(String user_id,String seq_no) {
    	int in_seq_no = Integer.parseInt(seq_no);
    	basketlistMapper.deleteBasketlist(user_id,in_seq_no);
    }
    
    
    
}

