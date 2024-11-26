package edu.ict.ex.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.notice.mapper.ReviewMapper;
import edu.ict.ex.notice.vo.ReviewVO;
import edu.ict.ex.simulation.page.Criteria;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewVO> getAllReview() {
		return reviewMapper.getAllReview(); // ReviewMapper를 통해 리뷰 목록 조회
	}
	
	public List<ReviewVO> getReviewsByGoodsCode(String goods_code) {
	    return reviewMapper.getReviewsByGoodsCode(goods_code);  // 상품 코드에 맞는 리뷰 반환
	}

	public ReviewVO getReviewDetail(int seq_no) {
		return reviewMapper.getReviewDetail(seq_no); // ReviewMapper를 통해 특정 리뷰 조회
	}

	public int updateReview(ReviewVO review) {
		return reviewMapper.updateReview(review); // 리뷰 수정
	}

	
	public void createReview(ReviewVO reviewVO) {
		reviewMapper.createReview(reviewVO); // 리뷰 등록
	}


	public void updateStatus(int seq_no,int status) {
		reviewMapper.updateStatus(seq_no,status); // 리뷰 블라인드 전환
	}
	
	//페이징 설정1
	public int getTotal() {            
		return reviewMapper.getTotalCount();
	}
	
	//페이징 설정2
	public List<ReviewVO> getListWithPaging(Criteria cri) {      
		return reviewMapper.getListWithPaging(cri);
	}
	
}
