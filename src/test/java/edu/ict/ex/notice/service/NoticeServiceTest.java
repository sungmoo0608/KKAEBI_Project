package edu.ict.ex.notice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class NoticeServiceTest {

	@Autowired
	private NoticeService noticeService;

	@Test
	void testGetAllNotice() {
		for(NoticeVO vo: noticeService.getAllNotice()) {
			System.out.println(vo);
		}
	}

}
