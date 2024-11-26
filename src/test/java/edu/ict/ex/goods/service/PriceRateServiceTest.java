package edu.ict.ex.goods.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.goods.vo.BasepriceVO;
import edu.ict.ex.goods.vo.ExchangerateVO;
import edu.ict.ex.goods.vo.StockpriceVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PriceRateServiceTest {

	@Autowired
	private PriceRateService service;

	@Disabled
	@Test
	void testGetCodeBPrice() {
		for(BasepriceVO vo:service.getCodeBPrice(1012)) {
			System.out.println(vo);
		}
	}
	
	@Disabled
	@Test
	void testGetExchangeRate() {
		for(ExchangerateVO vo:service.getExchangeRate(1025)) {
			System.out.println(vo);
		}
	}
	
	@Test
	void testGetStockpirce() {
		for(StockpriceVO vo:service.getStockpirce(1029)) {
			System.out.println(vo);
		}
	}
}

