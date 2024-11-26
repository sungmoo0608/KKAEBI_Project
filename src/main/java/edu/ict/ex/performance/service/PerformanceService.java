package edu.ict.ex.performance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ict.ex.performance.mapper.PerformanceMapper;
import edu.ict.ex.performance.vo.PerformanceAllVO;
import edu.ict.ex.performance.vo.PerformanceCustomerDetailVO;
import edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PerformanceService{
    
    private final PerformanceMapper performanceMapper;
    
    public List<PerformanceAllVO> searchPerformanceAllList(Integer in_grade) {
    	
    	int st_grade = 0;
    	int end_grade = 0;

    	if (in_grade > 0 && in_grade < 9) {
    		st_grade = in_grade;
    		end_grade = in_grade;
    	} else  {
    		st_grade = 0;
    		end_grade = 9;
    	} 
    	System.out.println(">>>searchPerformanceAllList ===> [" + in_grade + "]  [" + st_grade + "]  [" + end_grade+ "]  " );
    	
        return performanceMapper.searchPerformanceAllList(st_grade,end_grade); // Mapper 메서드 호출
    }

    public List<PerformanceCustomerSummaryVO> getPerformanceCustomerSummary(String user_id) {
    	
    	System.out.println(">>>getPerformanceCustomerSummary ===> [" + user_id + "] ");
    	
        return performanceMapper.searchPerformanceCustomerSummaryList(user_id); // Mapper 메서드 호출
    }

    public List<PerformanceCustomerDetailVO> getPerformanceCustomerDetail(String user_id,String goods_gubun) {
    	
    	int in_goods_gubun = Integer.parseInt(goods_gubun);
    	int st_goods_gubun = 0;
    	int end_goods_gubun = 0;

    	if (in_goods_gubun > 0) {
    		st_goods_gubun = in_goods_gubun;
    		end_goods_gubun = in_goods_gubun;
    	} else  {
    		st_goods_gubun = 0;
    		end_goods_gubun = 9;
    	} 
    	System.out.println(">>>getPerformanceCustomerDetail ===> [" + goods_gubun + "]  [" + st_goods_gubun + "]  [" + end_goods_gubun+ "]  " );
    	
        return performanceMapper.searchPerformanceCustomerDetailList(user_id,st_goods_gubun,end_goods_gubun); // Mapper 메서드 호출
    }

}

