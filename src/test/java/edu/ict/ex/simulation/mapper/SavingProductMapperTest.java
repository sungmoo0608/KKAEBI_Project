package edu.ict.ex.simulation.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SavingProductMapperTest {

	@Autowired
	private SavingProductMapper savingProductMapper;

	@Disabled
	@Test
	void testGetSavingProductList() {
		System.out.println(savingProductMapper.getSavingProductList());
	}
	
	@Disabled
	@Test
	void testGetSavingProductOptionList() {
		System.out.println(savingProductMapper.getSavingProductOptionList());
	}
	
	@Test
	void testRead() {
		System.out.println(savingProductMapper.read("10511008001278000"));
	}
	

	
}
