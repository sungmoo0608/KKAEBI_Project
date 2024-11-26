package edu.ict.ex.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.notice.service.ReviewUsService;
import edu.ict.ex.notice.vo.ReviewUsVO;

@Controller
@RequestMapping("/reviewus")
public class ReviewUsController {

	@Autowired
	private ReviewUsService reviewusService;

	// 공지사항 전체
	@GetMapping("/list")
	public String reviewusList(Model model) {
		model.addAttribute("reviewus", reviewusService.getAllReviewUs());
		return "reviewus/list";
	}

	// 공지사항 상세
	@GetMapping("/detail")
	public String getReviewUsDetail(@RequestParam("seq_no") int seq_no, Model model) {
		model.addAttribute("reviewus", reviewusService.getReviewUsDetail(seq_no));
		return "reviewus/detail";
	}

	// 게시물 등록 폼
	@GetMapping("/create")
	public String ReviewNoticeForm(Model model) {
		model.addAttribute("reviewus", new ReviewUsVO());
		return "reviewus/create";
	}

	// 게시물 등록 처리
	@PostMapping("/create")
	public String createReviewUS(@ModelAttribute ReviewUsVO reviewusVO) {
		reviewusService.createReviewUs(reviewusVO); // 공지사항 저장
		return "redirect:/reviewus/list";
	}

	// 게시물 변경폼
	@GetMapping("/update")
	public String updateReviewUSForm(@RequestParam("seq_no") int seq_no, Model model) {
		model.addAttribute("reviewus", reviewusService.getReviewUsDetail(seq_no));
		return "reviewus/update";
	}

	// 게시물 변경처리
	@PostMapping("/update")
	public String updateReviewUs(@ModelAttribute ReviewUsVO reviewus) {
		reviewusService.updateReviewUs(reviewus);
		return "redirect:/reviewus/list";

	}
}
