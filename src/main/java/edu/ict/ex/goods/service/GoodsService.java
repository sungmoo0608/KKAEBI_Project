package edu.ict.ex.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.goods.mapper.GoodsMapper;
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


@Service
public class GoodsService {
	
    @Autowired
    private GoodsMapper goodsMapper;

	// 상품 전체 조회
	public List<GoodsVO> getGoodsList(){
		System.out.println("getGoodsList() ..");

		return goodsMapper.getGoodsList();
	}
	
	// 예금 상품 조회
	public List<GoodsInterestrateProviderVO> getDepositList(){
		System.out.println("getDepositList() ..");

		return goodsMapper.getDepositList();
	}
	
	// 펀드 상품 조회
	public List<GoodsBasepriceProviderVO> getFundList(){
		System.out.println("getFundList() ..");

		return goodsMapper.getFundList();
	}
	
	// 외환 상품 조회
	public List<GoodsExchangerateProviderVO> getExchangeList(){
		System.out.println("getExchangeList() ..");

		return goodsMapper.getExchangeList();
	}
	
	// 주식 상품 조회
	public List<GoodsStockpriceProviderVO> getStockList(){
		System.out.println("getStockList() ..");

		return goodsMapper.getStockList();
	}
	
	// 모든 상품 조회
	public List<GoodsAllVO> getAllList(){
		System.out.println("getAllList() ..");

		return goodsMapper.getAllList();
	}
	
	// 상품 상세 보기
	public GoodsVO get(int goodscode) {
		
		System.out.println("get()..");
		
		GoodsVO goods = new GoodsVO();
		goods.setGoods_code(goodscode);
		
		return goodsMapper.read(goodscode);
	}
	
	// 예금 상품 상세 보기
	public GoodsDepositListVO get1(int depositCode) {
		
		System.out.println("get()..");
		
		GoodsDepositListVO goods = new GoodsDepositListVO();
		goods.setGoods_code(depositCode);
		
		return goodsMapper.getDepositCode(depositCode);
	}
	
	// 펀드 상품 상세 보기
	public GoodsFundListVO get2(int fundCode) {
		
		System.out.println("get()..");
		
		GoodsFundListVO goods = new GoodsFundListVO();
		goods.setGoods_code(fundCode);
		
		return goodsMapper.getFundCode(fundCode);
	}
	
	// 외환 상품 상세 보기
	public GoodsExListVO get3(int exCode) {
		
		System.out.println("get()..");
		
		GoodsExListVO goods = new GoodsExListVO();
		goods.setGoods_code(exCode);
		
		return goodsMapper.getExCode(exCode);
	}
	
	// 주가 상품 상세 보기
	public GoodsStockListVO get4(int stockCode) {
		
		System.out.println("get()..");
		
		GoodsStockListVO goods = new GoodsStockListVO();
		goods.setGoods_code(stockCode);
		
		return goodsMapper.getStockCode(stockCode);
	}

	//상품 추가
	public int createGoods(GoodsVO goods) {

		System.out.println("createGoods()..");
		
		return goodsMapper.insertGoods(goods);
	}

	
	//상품 수정
	public int modifyGoods(GoodsVO goods) {

		System.out.println("modifyGoods()..");
		
		return goodsMapper.modifyGoods(goods);
	}
	
	
	// 상품 삭제
	public int delete(int goodscode) {
		
		System.out.println("delete()..");

		return goodsMapper.delete(goodscode);
	}
	
	// 상품 진열 미진열
	public int display(GoodsVO goods) {
		
		System.out.println("display()..");

		return goodsMapper.display(goods);
	}
}
