package edu.ict.ex.basketlist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.basketlist.vo.BasketlistDetailVO;
import edu.ict.ex.basketlist.vo.BasketlistVO;


@Mapper
public interface BasketlistMapper {

	// 전체 고객의 실적을 조회
    List<BasketlistVO> searchBasketlistSummaryList(String user_id);
	
	// 전체 고객의 실적을 조회
    List<BasketlistDetailVO> searchBasketlistDetailList(String user_id,Integer st_goods_gubun,Integer end_goods_gubun);

    // 게시물 정보를 업데이트합니다.
    void deleteBasketlist(String user_id,Integer seq_no);
    
    // 게시물 정보를 업데이트합니다.
    void insertBasketlist(String user_id,Integer goods_code);

}
