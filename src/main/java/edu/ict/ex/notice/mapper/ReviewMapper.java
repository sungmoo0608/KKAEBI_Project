package edu.ict.ex.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.notice.vo.ReviewVO;
import edu.ict.ex.simulation.page.Criteria;

@Mapper
public interface ReviewMapper {

	List<ReviewVO> getAllReview(); // 전체 조회

	List<ReviewVO> getReviewsByGoodsCode(String goods_code);
    
	ReviewVO getReviewDetail(int seq_no); // 리뷰 자세히 보기

	int updateReview(ReviewVO review); // 업데이트

	void createReview(ReviewVO review); // 생성

	void updateStatus(int seq_no,int status); //삭제
	
	//페이징 관련
	int getTotalCount();
	List<ReviewVO> getListWithPaging(Criteria cri);
	
}
