package edu.ict.ex.basketlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ict.ex.basketlist.mapper.BasketlistMapper;
import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import edu.ict.ex.basketlist.vo.GoodsPriceVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BasketlistService{
	
    private final  BasketlistMapper basketlistMapper;
    
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
    
    public void insertBasketlist(String user_id,String goods_code) {
    	int in_goods_code = Integer.parseInt(goods_code);
    	basketlistMapper.insertBasketlist(user_id,in_goods_code);
    }
    
    

    public GoodsPriceVO getGoodsPriceInitFetch(Integer goods_gubun,Integer goods_code) {
        return basketlistMapper.getGoodsPriceInitFetch(goods_gubun,goods_code);
    }
    
    public void createGoodsPriceDeposit(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.createGoodsPriceDeposit(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }
    
    public void updateGoodsPriceDeposit(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.updateGoodsPriceDeposit(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }
    
    public void createGoodsPriceFund(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.createGoodsPriceFund(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }
    
    public void updateGoodsPriceFund(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.updateGoodsPriceFund(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }

    public void createGoodsPriceExchange(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.createGoodsPriceExchange(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }
    
    public void createGoodsPriceStock(Integer goods_gubun,Integer goods_code,double tr_price) {
    	basketlistMapper.createGoodsPriceStock(goods_gubun,goods_code,tr_price); // 게시물 생성 메서드
    }
    
    public GoodsPriceVO getGoodsPriceRecheckFetch(Integer goods_gubun,Integer goods_code,double tr_price) {
        return basketlistMapper.getGoodsPriceRecheckFetch(goods_gubun,goods_code,tr_price);
    }
    
}

