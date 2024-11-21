package edu.ict.ex.performance.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.performance.vo.PerformanceAllVO;
import edu.ict.ex.performance.vo.PerformanceCustomerDetailVO;
import edu.ict.ex.performance.vo.PerformanceCustomerSummaryVO;


@Mapper
public interface PerformanceMapper {

	// 전체 고객의 실적을 조회
    List<PerformanceAllVO> searchPerformanceAllList(Integer st_grade,Integer end_grade);
	
	// 전체 고객의 실적을 조회
    List<PerformanceCustomerSummaryVO> searchPerformanceCustomerSummaryList(String user_id);
	
	// 전체 고객의 실적을 조회
    List<PerformanceCustomerDetailVO> searchPerformanceCustomerDetailList(String user_id,Integer st_goods_gubun,Integer end_goods_gubun);

	
}
