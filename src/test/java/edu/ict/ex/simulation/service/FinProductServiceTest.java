package edu.ict.ex.simulation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.simulation.vo.FinProductVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FinProductServiceTest {

	@Autowired
	private FinProductService finProductService;

	@Test
	void testGetList() {
		for(FinProductVO vo: finProductService.getFinProductList()) {
			System.out.println(vo);
		}
	}

}
