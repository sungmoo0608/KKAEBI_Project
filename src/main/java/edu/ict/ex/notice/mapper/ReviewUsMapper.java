package edu.ict.ex.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.notice.vo.ReviewUsVO;

@Mapper
public interface ReviewUsMapper {

	List<ReviewUsVO> getAllReviewUs(); // 전체 조회

	ReviewUsVO getReivewDetailUs(int seq_no); // 리뷰 자세히 보기

	void updateReviewUs(ReviewUsVO review); // 업데이트

	void createReviewUs(ReviewUsVO reviewus); // 생성

	void deleteReviewUs(int seq_no); //삭제
}
