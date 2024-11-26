package edu.ict.ex.performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ict.ex.performance.service.PerformanceService;
import edu.ict.ex.performance.vo.PerformanceAllVO;
import edu.ict.ex.performance.vo.PerformanceCustomerDetailVO;
import edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO;

 
@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    // 전체가입자별 실적조회 - 첫화면(조건 검색후 조회 실행)
    @GetMapping("/performanceall")
    public String mnglist(Model model) {
        System.out.println(">>>>> performanceall");
        return "performance/performanceall_init"; 
    }
    
    // 관리자용
    @GetMapping("/performanceall_list") 
    public String mngsearchList(PerformanceAllVO vo, Model model) {

        System.out.println(">>>>> performanceall_list");
    	System.out.println("PerformanceAllVO vo =["+ vo + "]");
    	
        List<PerformanceAllVO> searchResults = performanceService.searchPerformanceAllList(vo.getIn_grade());
        model.addAttribute("PerformanceAllList", searchResults);
        return "performance/performanceall_list"; // 검색 결과를 리스트 페이지에 반환
    }
    // 시장정보 상세조회[관리자용]
    @GetMapping("/customer")
    public String getCustomer(@RequestParam("user_id") String user_id, Model model) {

        System.out.println(">>>>> getCustomer  > >> 1");

        List<PerformanceCustomerSummaryVO> customer = performanceService.getPerformanceCustomerSummary(user_id);
        model.addAttribute("PerformanceCustomerSummaryList", customer);

        System.out.println(">>>>> getCustomer  > >> 2");

        List<PerformanceCustomerDetailVO> customerdet = performanceService.getPerformanceCustomerDetail(user_id,"0");
        model.addAttribute("PerformanceCustomerDetailList", customerdet);
 
        System.out.println(">>>>> getCustomer  > >> 3");

        return "performance/performancecustomer_list"; 
    }
    
    // 시장정보 상세조회[관리자용]
    @GetMapping("/customerdetail")
    public String getCustomerDetail(@RequestParam("user_id") String user_id,@RequestParam("goods_gubun") String goods_gubun, Model model) {

        System.out.println(">>>>> getCustomerDetail  > >> 1");

        List<PerformanceCustomerDetailVO> customerdet = performanceService.getPerformanceCustomerDetail(user_id,goods_gubun);
        model.addAttribute("PerformanceCustomerDetailList", customerdet);
 
        System.out.println(">>>>> getCustomerDetail  > >> 2");

        return "performance/performancecustomerdet_list"; 
    }
    
    
}
