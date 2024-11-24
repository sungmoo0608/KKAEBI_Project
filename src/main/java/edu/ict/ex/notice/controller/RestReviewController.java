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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.notice.service.ReviewService;
import edu.ict.ex.notice.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/reviewr")
public class RestReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 목록 전체 - 페이징 없음
    @GetMapping("/list")
    public List<ReviewVO> getAllReview(@RequestParam(required = false) String goods_code) {
        if (goods_code != null && !goods_code.isEmpty()) {
            return reviewService.getReviewsByGoodsCode(goods_code);  // 상품 코드에 맞는 리뷰만 반환
        }
        return reviewService.getAllReview();  // 상품 코드가 없으면 전체 리뷰 반환
    }
    
    // 공지사항 상세
    @GetMapping("/{seq_no}")
    public ReviewVO content(ReviewVO reviewVO){
		log.info("content()...");
		
		return reviewService.getReviewDetail(reviewVO.getSeq_no());
	}

    // 게시물 등록 처리
    @PostMapping("/create")
    public ResponseEntity<String> write(@RequestBody ReviewVO review){
		
		log.info("write..");
		log.info("review" + review);
		
		ResponseEntity<String> entity = null;
		
		try {
			reviewService.createReview(review);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

    // 게시물 변경처리
	@PutMapping("/modify")	// 경로 변수
	public ResponseEntity<String> modify(@RequestBody ReviewVO review){
		
		log.info("modify..");
		log.info("review" + review);
		
		ResponseEntity<String> entity = null;
		
		try {
			int rn = reviewService.updateReview(review);
			entity = new ResponseEntity<String>(String.valueOf(rn),HttpStatus.OK);
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
	        reviewService.updateStatus(seq_no, status);  // 서비스에서 상태 업데이트 처리
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
