package edu.ict.ex.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.goods.vo.BasepriceVO;
import edu.ict.ex.goods.vo.ExchangerateVO;
import edu.ict.ex.goods.vo.StockpriceVO;

@Mapper
public interface PriceRateMapper {

	// 펀드 전체 기준가 조회
	List<BasepriceVO> getBasepriceList();

	// 특정 펀드 기준가 기간 조회
	List<BasepriceVO> getCodeBPrice(int goods_code);

	// 외환 조회
	List<ExchangerateVO> getExchangerateList();
	
	// 특정 환율 기간 조회
	List<ExchangerateVO> getExchangeRate(int goods_code);

	// 주식가 조회
	List<StockpriceVO> getStockpriceList();
	
	// 특정 주식 기간 조회
	List<StockpriceVO> getStockpirce(int goods_code);

}
