package edu.ict.ex.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.goods.vo.GoodsAllVO;
import edu.ict.ex.goods.vo.GoodsBasepriceProviderVO;
import edu.ict.ex.goods.vo.GoodsDepositListVO;
import edu.ict.ex.goods.vo.GoodsExListVO;
import edu.ict.ex.goods.vo.GoodsExchangerateProviderVO;
import edu.ict.ex.goods.vo.GoodsFundListVO;
import edu.ict.ex.goods.vo.GoodsInterestrateProviderVO;
import edu.ict.ex.goods.vo.GoodsStockListVO;
import edu.ict.ex.goods.vo.GoodsStockpriceProviderVO;
import edu.ict.ex.goods.vo.GoodsVO;

@Mapper
public interface GoodsMapper {

	// 상품 목록 조회
    List<GoodsVO> getGoodsList();  
    
	// 예금 상품 조회
    List<GoodsInterestrateProviderVO> getDepositList();  
    
	// 펀드 상품 조회
    List<GoodsBasepriceProviderVO> getFundList();  
    
	// 외환 상품 조회
    List<GoodsExchangerateProviderVO> getExchangeList();  
    
	// 주식 상품 조회
    List<GoodsStockpriceProviderVO> getStockList();  
    
	// 모든 상품 조회
    List<GoodsAllVO> getGoodsAll();  
    
	// 상품 상세 보기
    GoodsVO read(int goodscode);
    
    // 예금 상품 상세 보기
    GoodsDepositListVO getDepositCode(int depositCode);
    
    // 펀드 상품 상세 보기
    GoodsFundListVO getFundCode(int fundCode);

    // 외환 상품 상세 보기
    GoodsExListVO getExCode(int exCode);
    
    // 주식 상품 상세 보기
    GoodsStockListVO getStockCode(int stockCode);
    
    
	//상품 수정
    int modifyGoods(GoodsVO goodsVO);	
    
	//상품 추가
    int insertGoods(GoodsVO goodsVO);	
    
	// 상품 삭제
    int delete(int goodscode);
    
    // 상품 진열 미진열 변경
    int display(GoodsVO goodsVO);
}
