package edu.ict.ex.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.notice.vo.NoticeUsVO;

@Mapper
public interface NoticeUsMapper {
    
    List<NoticeUsVO> getAllUsNotice(); // 전체 조회
    
	NoticeUsVO getNoticeUsDetail(int seq_no);

    
}
