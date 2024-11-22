package edu.ict.ex.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.goods.service.PriceRateService;
import edu.ict.ex.goods.vo.BasepriceVO;
import edu.ict.ex.goods.vo.ExchangerateVO;
import edu.ict.ex.goods.vo.StockpriceVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/pricerate")
public class RestPriceRateController {

	@Autowired
	private PriceRateService priceRateService;

	// 펀드 기준가 통합 조회
	@GetMapping("/baseprice")
	public List<BasepriceVO> baseprice() {

		log.info("baseprice()...");

		return priceRateService.getBasepriceList();
	}

	//특정 번호 펀드 가격 출력
	@GetMapping("/baseprice/{goods_code}")	// 경로 변수
    public List<BasepriceVO> getCodeBPrice(@PathVariable int goods_code) {
		
		log.info("goods_code: {}", goods_code);
		
        return priceRateService.getCodeBPrice(goods_code);
    }
	
	// 외환 변동 통합 조회
	@GetMapping("/exchangerate")
	public List<ExchangerateVO> exchangerate() {

		log.info("baseprice()...");

		return priceRateService.getExchangerateList();
	}
	
	// 특정 환율 출력ㄴ
	@GetMapping("/exchangerate/{goods_code}")	// 경로 변수
    public List<ExchangerateVO> getExchangeRate(@PathVariable int goods_code) {
		
		log.info("goods_code: {}", goods_code);
		
        return priceRateService.getExchangeRate(goods_code);
    }
	
	
	// 주가 통합 조회
	@GetMapping("/stockprice")
	public List<StockpriceVO> getStockpriceList() {

		log.info("stockprice()...");

		return priceRateService.getStockpriceList();
	}
	
	// 특정 환율 출력
	@GetMapping("/stockprice/{goods_code}")	// 경로 변수
    public List<StockpriceVO> getStockpirce(@PathVariable int goods_code) {
		
		log.info("goods_code: {}", goods_code);
		
        return priceRateService.getStockpirce(goods_code);
    }
	
}
