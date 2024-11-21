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
	public void updateStatusToDeleted(int seq_no) {
		noticeMapper.deleteNotice(seq_no);
	}

	// 만료된 공지사항 상태 변경
	public void updateExpiredNoticesStatus(String expireId) {
		noticeMapper.updateExpiredNoticesStatus(expireId);
	}
}