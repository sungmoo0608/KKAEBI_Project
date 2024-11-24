package edu.ict.ex.goods.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.goods.service.GoodsService;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/goodsrest")
public class RestGoodsController {

	@Autowired
	private GoodsService goodsService;

	// 예금 상품 목록
	@GetMapping("/Depositlist")
	public List<GoodsInterestrateProviderVO> depositlist() {

		log.info("Depositlist()...");

		return goodsService.getDepositList();
	}

	// 예금 상품 조회
	@GetMapping("/Depositlist/{goods_code}") // 경로 변수
	public GoodsDepositListVO content(GoodsDepositListVO goodsDepositListVO) {
		log.info("content()...");

		return goodsService.get1(goodsDepositListVO.getGoods_code());
	}

	// 펀드 상품 목록
	@GetMapping("/Fundlist")
	public List<GoodsBasepriceProviderVO> fundlist() {

		log.info("Fundlist()...");

		return goodsService.getFundList();
	}

	// 펀드 상품 조회
	@GetMapping("/Fundlist/{goods_code}") // 경로 변수
	public GoodsFundListVO content(GoodsFundListVO goodsFundListVO) {
		log.info("content()...");

		return goodsService.get2(goodsFundListVO.getGoods_code());
	}

	// 외환 상품 목록
	@GetMapping("/Exchangelist")
	public List<GoodsExchangerateProviderVO> exchangelist() {

		log.info("Exchangelist()...");

		return goodsService.getExchangeList();
	}

	// 외환 상품 조회
	@GetMapping("/Exchangelist/{goods_code}") // 경로 변수
	public GoodsExListVO content(GoodsExListVO goodsExListVO) {
		log.info("content()...");

		return goodsService.get3(goodsExListVO.getGoods_code());
	}

	// 주식 상품 목록
	@GetMapping("/Stocklist")
	public List<GoodsStockpriceProviderVO> stockList() {

		log.info("Stocklist()...");

		return goodsService.getStockList();
	}

	// 주식 상품 조회
	@GetMapping("/Stocklist/{goods_code}") // 경로 변수
	public GoodsStockListVO content(GoodsStockListVO goodsStockListVO) {
		log.info("content()...");

		return goodsService.get4(goodsStockListVO.getGoods_code());
	}

	// 예금/외환/펀드/주식 정보 상품 목록
	@GetMapping("/Alllist")
	public List<GoodsAllVO> allList() {

		log.info("Stocklist()...");

		return goodsService.getGoodsAll();
	}
	
	// 기본 Goods 상품 목록
	@GetMapping("/goodscodelist")
	public List<Integer> getGoodsList() {

		log.info("Stocklist()...");

		return goodsService.getGoodsList();
	}


	// 특정 번호를 받으면 해당 정보 서비스
	@GetMapping("/{goods_code}") // 경로 변수
	public GoodsVO content(GoodsVO goodsVO) {
		log.info("content()...");

		return goodsService.get(goodsVO.getGoods_code());
	}

	// 상품 수정
	@PutMapping("/") // 경로 변수
	public ResponseEntity<String> modify(@RequestBody GoodsVO goods) {

		log.info("modify..");
		log.info("goods" + goods);

		ResponseEntity<String> entity = null;

		try {
			int rn = goodsService.modifyGoods(goods);
			entity = new ResponseEntity<String>(String.valueOf(rn), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 상품 추가
	@PostMapping("/") // 경로 변수
	public ResponseEntity<String> write(@RequestBody GoodsVO goods) {

		log.info("write..");
		log.info("board" + goods);

		ResponseEntity<String> entity = null;

		try {
			goodsService.createGoods(goods);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 상품 상태 업데이트
	@PutMapping("/updateStatus/{goods_code}")
	public ResponseEntity<?> updateStatus(@PathVariable int goods_code, @RequestBody Map<String, Integer> request) {
		int status = request.get("status"); // 상태 값을 받아옴
		boolean success = goodsService.updateStatus(goods_code, status); // 상태를 업데이트

		if (success) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("상태 업데이트 실패");
		}
	}

}
