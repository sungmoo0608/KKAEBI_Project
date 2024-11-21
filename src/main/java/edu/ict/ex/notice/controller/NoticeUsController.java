package edu.ict.ex.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.notice.service.NoticeUsService;

@Controller
@RequestMapping("/noticeus")
public class NoticeUsController {

    @Autowired
    private NoticeUsService noticeusService;

    // 공지사항 전체
    @GetMapping("/list")
    public String noticeusList(Model model) {
        model.addAttribute("noticeus", noticeusService.getAllUsNotice());
        return "noticeus/list";
    }

    // 공지사항 상세
    @GetMapping("/detail")
    public String getNoticeUsDetail(@RequestParam("seq_no") int seq_no, Model model) {
        model.addAttribute("noticeus", noticeusService.getNoticeUsDetail(seq_no));
        return "noticeus/detail";
    }
}
