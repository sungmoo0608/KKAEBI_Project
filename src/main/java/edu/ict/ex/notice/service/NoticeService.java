package edu.ict.ex.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.notice.mapper.NoticeMapper;
import edu.ict.ex.notice.vo.NoticeVO;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;

	// 전체 공지사항 조회
	public List<NoticeVO> getAllNotice() {
		System.out.println("getAllNotice() ..");	
		return noticeMapper.getAllNotice();
	}

	// 공지사항 상세 조회
	public NoticeVO getNoticeDetail(int seq_no) {
		return noticeMapper.getNoticeDetail(seq_no);
	}
	
	// 공지사항 수정
	public int updateNotice(NoticeVO notice) {
		System.out.println("updateNotice()..");		
		return noticeMapper.updateNotice(notice);
	}

	// 공지사항 생성
	public void createNotice(NoticeVO noticeVO) {
		noticeMapper.createNotice(noticeVO);
	}

	// 공지사항 상태를 9로 변경 (삭제 처리)
	public void updateStatus(int seq_no, int status) {
	    System.out.println("Update status for seq_no: " + seq_no + " to status: " + status);
	    noticeMapper.updateStatusTo(seq_no, status);
	}

	// 만료된 공지사항 상태 변경
	public void updateExpiredNoticesStatus(String expireId) {
		noticeMapper.updateExpiredNoticesStatus(expireId);
	}
	
	// 공지대상 변경
    public boolean updateTargetTo(int seq_no, int notice_target) {
        System.out.println("공지 대상 변경 중... 게시글 번호: " + seq_no + ", 대상: " + notice_target);
        return noticeMapper.updateTargetTo(seq_no, notice_target); // 상태 변경
    }
	
}