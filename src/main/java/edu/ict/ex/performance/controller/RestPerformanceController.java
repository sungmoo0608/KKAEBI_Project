package edu.ict.ex.performance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.performance.service.PerformanceService;
import edu.ict.ex.performance.vo.PerformanceAllVO;
import edu.ict.ex.performance.vo.PerformanceCustomerDetailVO;
import edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/performancerest")
public class RestPerformanceController {

    @Autowired
    private PerformanceService performanceService;

    // 전체가입자별 실적조회 - 첫화면(조건 검색후 조회 실행)
    @GetMapping("/performanceall")
    public String mnglist() {
        System.out.println(">>>>> performanceall");
        return "performance/performanceall_init"; // You can modify this to return JSON or other content as per need
    }

    // 관리자용
    @GetMapping("/performanceall_list")
    public List<PerformanceAllVO> mngsearchList(PerformanceAllVO vo) {
        System.out.println(">>>>> performanceall_list");
        System.out.println("PerformanceAllVO vo =[" + vo + "]");
        
        List<PerformanceAllVO> searchResults = performanceService.searchPerformanceAllList(vo.getIn_grade());
        return searchResults; // 검색 결과를 List 형태로 반환
    }

    // 시장정보 상세조회[관리자용]
    @GetMapping("/customer")
    public Map<String, Object> getCustomer(@RequestParam("user_id") String user_id) {
        System.out.println(">>>>> getCustomer  > >> 1");

        List<PerformanceCustomerSummaryVO> customer = performanceService.getPerformanceCustomerSummary(user_id);
        List<PerformanceCustomerDetailVO> customerdet = performanceService.getPerformanceCustomerDetail(user_id, "0");

        // Map을 사용해 두 리스트를 한번에 반환 (자동으로 JSON으로 변환)
        Map<String, Object> response = new HashMap<>();
        response.put("PerformanceCustomerSummaryList", customer);
        response.put("PerformanceCustomerDetailList", customerdet);

        System.out.println(">>>>> getCustomer  > >> 3");

        return response;
    }

    // 시장정보 상세조회[관리자용]
    @GetMapping("/customerdetail")
    public List<PerformanceCustomerDetailVO> getCustomerDetail(
            @RequestParam("user_id") String user_id,
            @RequestParam("goods_gubun") String goods_gubun) {

        System.out.println(">>>>> getCustomerDetail  > >> 1");

        List<PerformanceCustomerDetailVO> customerdet = performanceService.getPerformanceCustomerDetail(user_id, goods_gubun);
        
        System.out.println(">>>>> getCustomerDetail  > >> 2");

        return customerdet; // 상세 정보를 List 형태로 반환 (자동으로 JSON으로 변환)
    }
}