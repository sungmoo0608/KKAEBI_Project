package edu.ict.ex.basketlist.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsPriceVO {
	   //변수와 변수 각각의 데이터 타입 표시
		private String 	goods_code;
		private String 	goods_name;
		private String 	seqno;
		private String 	goods_gubun;
		private String 	goods_gubun_nm;
		private String 	provider_code;
		private String 	provider_nm;
		private String 	period_mm;
		private String 	job_gubun;
		private String 	curprice;
		private String 	befprice;
}
