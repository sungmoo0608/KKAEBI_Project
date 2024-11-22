package edu.ict.ex.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ict.ex.notice.vo.ReviewUsVO;

@Service
public interface ReviewUsService {

	List<ReviewUsVO> getAllReviewUs();

	ReviewUsVO getReviewUsDetail(int seq_no); 

	void createReviewUs(ReviewUsVO reviewus); 

	void updateReviewUs(ReviewUsVO reviewus);

	void updateStatusToDeletedReviewUs(int seq_no);

}
