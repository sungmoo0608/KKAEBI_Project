package edu.ict.ex.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.notice.service.NoticeService;
import edu.ict.ex.notice.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/noticerest")
public class RestNoticeController {

    @Autowired
    private NoticeService noticeService;

    // 공지사항 전체
    @GetMapping("/list")
	public List<NoticeVO> AllNotice() {

		log.info("noticeList()...");

		return noticeService.getAllNotice();
	}
    
    // 공지사항 조회
	@GetMapping("/{seq_no}")	// 경로 변수
	public NoticeVO content(NoticeVO noticeVO){
		log.info("content()...");
		
		return noticeService.getNoticeDetail(noticeVO.getSeq_no());
	}
	
	// 공지사항 수정
	@PutMapping("/")	// 경로 변수
	public ResponseEntity<String> modify(@RequestBody NoticeVO notice){
		
		log.info("modify..");
		log.info("notice" + notice);
		
		ResponseEntity<String> entity = null;
		
		try {
			int rn = noticeService.updateNotice(notice);
			entity = new ResponseEntity<String>(String.valueOf(rn),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//공지사항 등록
	@PostMapping("/")	// 경로 변수
	public ResponseEntity<String> write(@RequestBody NoticeVO notice){
		
		log.info("write..");
		log.info("board" + notice);
		
		ResponseEntity<String> entity = null;
		
		try {
			noticeService.createNotice(notice);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
    
}
