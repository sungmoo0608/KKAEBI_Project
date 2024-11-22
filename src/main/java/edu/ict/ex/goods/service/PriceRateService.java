package edu.ict.ex.goods.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.goods.mapper.PriceRateMapper;
import edu.ict.ex.goods.vo.BasepriceVO;
import edu.ict.ex.goods.vo.ExchangerateVO;
import edu.ict.ex.goods.vo.StockpriceVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceRateService {
	
    @Autowired
    private PriceRateMapper priceRateMapper;

	// 펀드 기준가 조회
	public List<BasepriceVO> getBasepriceList(){
		log.info("getBasepriceList() ..");

		return priceRateMapper.getBasepriceList();
	}
	
	// 특정 펀드 상품 가격 추이 보기
	public List<BasepriceVO> getCodeBPrice(int goods_code) {
		
		System.out.println("get()..");
		
        List<BasepriceVO> prices = priceRateMapper.getCodeBPrice(goods_code);
        
        if (prices == null || prices.isEmpty()) {
            log.warn("No prices found for goods_code: {}", goods_code);
        }
        
        return prices != null ? prices : new ArrayList<>();
	}
	
	// 외환 모든 목록 조회
	public List<ExchangerateVO> getExchangerateList(){
		log.info("getExchangerateList() ..");

		return priceRateMapper.getExchangerateList();
	}
	
	// 특정 외환 가격 추이 보기
	public List<ExchangerateVO> getExchangeRate(int goods_code) {
		
		System.out.println("get()..");
		
        List<ExchangerateVO> rate = priceRateMapper.getExchangeRate(goods_code);
        
        if (rate == null || rate.isEmpty()) {
            log.warn("No prices found for goods_code: {}", goods_code);
        }
        
        return rate != null ? rate : new ArrayList<>();
	}
	
	
	// 주식가 모든 목록 조회
	public List<StockpriceVO> getStockpriceList(){
		log.info("getStockpriceList() ..");

		return priceRateMapper.getStockpriceList();
	}
	
	
	// 특정 주식 가격 추이 보기
	public List<StockpriceVO> getStockpirce(int goods_code) {
		
		System.out.println("get()..");
		
        List<StockpriceVO> stockprice = priceRateMapper.getStockpirce(goods_code);
        
        if (stockprice == null || stockprice.isEmpty()) {
            log.warn("No prices found for goods_code: {}", goods_code);
        }
        
        return stockprice != null ? stockprice : new ArrayList<>();
	}
	
	
}
