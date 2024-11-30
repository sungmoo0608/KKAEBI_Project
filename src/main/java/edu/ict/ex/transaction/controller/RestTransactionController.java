package edu.ict.ex.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.transaction.service.TransactionService;
import edu.ict.ex.transaction.vo.TransactionVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/transaction")
public class RestTransactionController {

	@Autowired
	private TransactionService transactionService;

	// 상품투자 - 상품종류에 따른 투자를 위한 기본 정보 제공
	// 사용자정보,상품구분에 따른 투자화면,기본가격(이율/기준가/환율/주가)
	@GetMapping("/invest_init")
	public ResponseEntity<TransactionVO> getTransactionInit(@RequestParam("user_id") String user_id,
			@RequestParam("goods_gubun") String goods_gubun, @RequestParam("goods_code") String goods_code) {

		try {
			int in_goods_gubun = Integer.parseInt(goods_gubun);
			int in_goods_code = Integer.parseInt(goods_code);

			TransactionVO transaction = transactionService.getTransactionInitFetch(user_id, in_goods_code);

			// 상품 구분에 따라 데이터를 반환
			if (in_goods_gubun == 1) {
				return new ResponseEntity<>(transaction, HttpStatus.OK);
			} else if (in_goods_gubun == 2) {
				return new ResponseEntity<>(transaction, HttpStatus.OK);
			} else if (in_goods_gubun == 3) {
				return new ResponseEntity<>(transaction, HttpStatus.OK);
			} else if (in_goods_gubun == 4) {
				return new ResponseEntity<>(transaction, HttpStatus.OK);
			} else {
				log.error("Invalid goods_gubun: {}", goods_gubun); // 잘못된 상품 구분에 대한 로그
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// 투자 거래 처리
	@GetMapping("/invest")
	public ResponseEntity<TransactionVO> getTransaction(@RequestParam("user_id") String user_id,
			@RequestParam("goods_gubun") String goods_gubun, @RequestParam("goods_code") String goods_code,
			@RequestParam("tr_number") String tr_number, @RequestParam("tr_price") String tr_price,
			@RequestParam("tr_amt") String tr_amt) {

		try {
			int in_goods_gubun = Integer.parseInt(goods_gubun);
			int in_goods_code = Integer.parseInt(goods_code);
			double in_tr_number = Double.parseDouble(tr_number);
			double in_tr_price = Double.parseDouble(tr_price);
			double in_tr_amt = Double.parseDouble(tr_amt);

			// 거래가 유효한지 점검
			TransactionVO transactionchk = transactionService.getTransactionCheckFetch(user_id, in_goods_code,
					in_tr_number, in_tr_price, in_tr_amt);

			if (transactionchk == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			// 상품 유형에 따라 거래 생성
			if (in_goods_gubun == 1) {
				transactionService.createTransactionDeposit(transactionchk);
			} else if (in_goods_gubun == 2) {
				transactionService.createTransactionFund(transactionchk);
			} else if (in_goods_gubun == 3) {
				transactionService.createTransactionExchange(transactionchk);
			} else if (in_goods_gubun == 4) {
				transactionService.createTransactionStock(transactionchk);
			} else {
				log.error("Invalid goods_gubun during transaction creation: {}", goods_gubun);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			// 거래 후 업데이트된 거래 정보 반환
			TransactionVO transaction = transactionService.getTransactionRecheckFetch(user_id, in_goods_code,
					in_tr_amt);
			return new ResponseEntity<>(transaction, HttpStatus.OK);

		} catch (Exception e) {
			log.error(
					"Error in getTransaction for user_id: {}, goods_gubun: {}, goods_code: {}, tr_number: {}, tr_price: {}, tr_amt: {}",
					user_id, goods_gubun, goods_code, tr_number, tr_price, tr_amt, e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}