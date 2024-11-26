package edu.ict.ex.notice.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper mapper;

	@Disabled
	@Test
	void testGetAllNotice() {
		System.out.println(mapper.getAllNotice());
	}
	
	@Disabled
	@Test
	void testGetNoticeDetail() {
		System.out.println(mapper.getNoticeDetail(1));
	}


}

