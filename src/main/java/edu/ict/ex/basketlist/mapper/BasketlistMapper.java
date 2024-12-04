package edu.ict.ex.basketlist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;
import edu.ict.ex.basketlist.vo.GoodsPriceVO;


@Mapper
public interface BasketlistMapper {

	// 전체 고객의 실적을 조회
    List<BasketlistVO> searchBasketlistSummaryList(String user_id);
	
	// 전체 고객의 실적을 조회
    List<BasketlistDetailVO> searchBasketlistDetailList(String user_id,Integer st_goods_gubun,Integer end_goods_gubun);

    // 장바구니 블라인드 처리
    void deleteBasketlist(String user_id,Integer seq_no);
    
	// 장바구니 확인 후 있으면 블라인드 처리
    void updateBasketlistStatus(String user_id,Integer in_goods_code);
    
    // 장바구니 추가
    void insertBasketlist(String user_id,Integer in_goods_code);

	// 상품 가격 등록 초기화 화면
    GoodsPriceVO getGoodsPriceInitFetch(Integer goods_gubun,Integer goods_code);

	void createGoodsPriceDeposit(Integer goods_gubun,Integer goods_code,double tr_price);
	void updateGoodsPriceDeposit(Integer goods_gubun,Integer goods_code,double tr_price);

	void createGoodsPriceFund(Integer goods_gubun,Integer goods_code,double tr_price);
	void updateGoodsPriceFund(Integer goods_gubun,Integer goods_code,double tr_price);
	
	void createGoodsPriceExchange(Integer goods_gubun,Integer goods_code,double tr_price);
	
	void createGoodsPriceStock(Integer goods_gubun,Integer goods_code,double tr_price);
	
	// 상품 가격 등록 초기화 화면
    GoodsPriceVO getGoodsPriceRecheckFetch(Integer goods_gubun,Integer goods_code,double tr_price);

}
