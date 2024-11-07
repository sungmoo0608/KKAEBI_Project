package edu.ict.ex.simulation.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FinProductMapperTest {

	@Autowired
	private FinProductMapper finProductMapper;

	@Test
	void testGetFinProductList() {
		System.out.println(finProductMapper.getFinProductList());
	}

}
