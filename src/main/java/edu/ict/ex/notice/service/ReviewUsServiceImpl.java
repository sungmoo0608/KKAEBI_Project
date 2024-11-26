package edu.ict.ex.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.notice.mapper.ReviewUsMapper;
import edu.ict.ex.notice.vo.ReviewUsVO;

@Service
public class ReviewUsServiceImpl implements ReviewUsService {

	@Autowired
	private ReviewUsMapper reviewusMapper;

	@Override
	public List<ReviewUsVO> getAllReviewUs() {
		return reviewusMapper.getAllReviewUs(); // ReviewMapper를 통해 리뷰 목록 조회
	}

	@Override
	public ReviewUsVO getReviewUsDetail(int seq_no) {
		return reviewusMapper.getReivewDetailUs(seq_no); // ReviewMapper를 통해 특정 리뷰 조회
	}

	@Override
	public void createReviewUs(ReviewUsVO reviewusVO) {
		reviewusMapper.createReviewUs(reviewusVO); // 리뷰 등록
	}

	@Override
	public void updateReviewUs(ReviewUsVO reviewus) {
		reviewusMapper.updateReviewUs(reviewus); // 리뷰 수정
	}

	@Override
	public void updateStatusToDeletedReviewUs(int seq_no) {
		reviewusMapper.deleteReviewUs(seq_no);

	}
}
