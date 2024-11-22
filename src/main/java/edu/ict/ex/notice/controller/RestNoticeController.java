package edu.ict.ex.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		log.info("notice" + notice);
		
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
	
	@PutMapping("/{seq_no}/status")  // seq_no와 status를 경로 변수와 요청 본문으로 받음
	public ResponseEntity<Map<String, Object>> changeStatus(
	    @PathVariable int seq_no, @RequestBody Map<String, Integer> statusMap) {

	    log.info("Change status for seq_no: " + seq_no);

	    Map<String, Object> response = new HashMap<>();

	    try {
	        int status = statusMap.get("status");  // status 값 추출
	        noticeService.updateStatus(seq_no, status);  // 서비스에서 상태 업데이트 처리
	        response.put("status", "success");
	        response.put("message", "공지사항 상태가 성공적으로 업데이트되었습니다.");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	        log.error("공지사항 상태 업데이트 중 오류 발생", e);
	        response.put("status", "error");
	        response.put("message", e.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	    }
	}
    
}
