package edu.ict.ex.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.notice.vo.NoticeVO;

@Mapper
public interface NoticeMapper {
    
    List<NoticeVO> getAllNotice(); // 전체 조회
    
    NoticeVO getNoticeDetail(int seq_no); // 상세정보 조회
    
    int updateNotice(NoticeVO notice); // 업데이트
    
    void createNotice(NoticeVO notice); // 생성
    
    void updateStatusTo(int seq_no, int status);
    
	void updateExpiredNoticesStatus(String expire_Id);

	// 공지 대상 변경
    boolean updateTargetTo(int seq_no, int notice_target);
    
}
