package edu.ict.ex.goods.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PriceRateTest {

	@Autowired
	private PriceRateMapper mapper;

	@Disabled
	@Test
	void testGetBasepriceList() {
		System.out.println(mapper.getBasepriceList());
	}
	
	@Disabled
	@Test
	void testGetCodeBPrice() {
		System.out.println(mapper.getCodeBPrice(1012));
	}
	
	@Disabled
	@Test
	void testGetExchangerateList() {
		System.out.println(mapper.getExchangerateList());
	}
	
	@Test
	void testGetStockpriceList() {
		System.out.println(mapper.getStockpriceList());
	}
}

