package edu.ict.ex.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.goods.vo.ProviderVO;

@Mapper
public interface ProviderMapper {

	// 펀드 전체 기준가 조회
	List<ProviderVO> getProviderList();
	
	

}
