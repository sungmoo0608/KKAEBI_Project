package edu.ict.ex.basketlist.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasketlistMapperTest {

	@Autowired
	private BasketlistMapper mapper;
	
	@Test
	void test() {
		System.out.println(mapper);
	}

}
