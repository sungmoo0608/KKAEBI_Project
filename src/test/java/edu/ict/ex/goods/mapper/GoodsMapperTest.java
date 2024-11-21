package edu.ict.ex.goods.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class GoodsMapperTest {

	@Autowired
	private GoodsMapper mapper;

	@Disabled
	@Test
	void testGetGoodsList() {
		System.out.println(mapper.getGoodsList());
	}
	
	@Disabled
	@Test
	void testGetDepositList() {
		System.out.println(mapper.getDepositList());
	}
	
	@Disabled
	@Test
	void testGetFundList() {
		System.out.println(mapper.getFundList());
	}
	
	@Disabled
	@Test
	void testGetStockList() {
		System.out.println(mapper.getStockList());
	}
	
	@Disabled
	@Test
	void testRead() {
		System.out.println(mapper.read(1001));
	}
	
	@Disabled
	@Test
	void testGetDepositCode() {
		System.out.println(mapper.getDepositCode(1001));
	}
	
	@Disabled
	@Test
	void testGetFundCode() {
		System.out.println(mapper.getFundCode(1012));
	}
	
	@Disabled
	@Test
	void testGetExCode() {
		System.out.println(mapper.getExCode(1025));
	}
	
	@Disabled
	@Test
	void testGetStockCode() {
		System.out.println(mapper.getStockCode(1029));
	}
}

