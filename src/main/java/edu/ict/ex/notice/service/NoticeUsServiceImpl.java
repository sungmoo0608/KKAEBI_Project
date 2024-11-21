package edu.ict.ex.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.notice.mapper.NoticeUsMapper;
import edu.ict.ex.notice.vo.NoticeUsVO;

@Service
public class NoticeUsServiceImpl implements NoticeUsService {

    @Autowired
    private NoticeUsMapper noticeusMapper;

    // 전체 공지사항 조회
    @Override
    public List<NoticeUsVO> getAllUsNotice() {
        return noticeusMapper.getAllUsNotice(); 
    }

    // 공지사항 상세 조회
    @Override
    public NoticeUsVO getNoticeUsDetail(int seq_no) {
        NoticeUsVO notice = noticeusMapper.getNoticeUsDetail(seq_no); 
        if (notice == null) {
            throw new RuntimeException("Notice not found with seq_no: " + seq_no); // 예외 처리 예시
        }
        return notice;
    }
}