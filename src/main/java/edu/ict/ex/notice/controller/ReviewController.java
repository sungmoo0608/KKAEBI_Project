package edu.ict.ex.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.notice.service.ReviewService;
import edu.ict.ex.notice.vo.ReviewVO;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 공지사항 전체
    @GetMapping("/list")
    public String reviewList(Model model) {
        model.addAttribute("review", reviewService.getAllReview());
        return "review/list";
    }

    // 공지사항 상세
    @GetMapping("/detail")
    public String getReviewDetail(@RequestParam("seq_no") int seq_no, Model model) {
        model.addAttribute("review", reviewService.getReviewDetail(seq_no));
        return "review/detail";
    }

    // 게시물 등록 폼
    @GetMapping("/create")
    public String ReviewNoticeForm(Model model) {
        model.addAttribute("review", new ReviewVO());
        return "review/create";
    }

    // 게시물 등록 처리
    @PostMapping("/create")
    public String createReview(@ModelAttribute ReviewVO reviewVO) {
        reviewService.createReview(reviewVO); // 공지사항 저장
        return "redirect:/review/list";
    }

    // 게시물 변경폼
    @GetMapping("/update")
    public String updateReviewForm(@RequestParam("seq_no") int seq_no, Model model) {
        model.addAttribute("review", reviewService.getReviewDetail(seq_no));
        return "review/update";
    }

    // 게시물 변경처리
    @PostMapping("/update")
    public String updateReview(@ModelAttribute ReviewVO review) {
        reviewService.updateReview(review); // 공지사항 업데이트
        return "redirect:/review/list"; // 목록으로 리디렉션
    }

    // 게시물 삭제
//    @GetMapping("/delete")
//    public String deleteReview(@RequestParam("seq_no") int seq_no) {
//        reviewService.updateStatus(seq_no);
//        return "redirect:/review/list"; // 공지사항 목록 페이지로 리다이렉트
//    }
     
}
