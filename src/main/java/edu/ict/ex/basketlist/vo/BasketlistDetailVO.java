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
public class BasketlistDetailVO {
	private String 	user_id;
	private String 	name;
	private String 	seq_no;
	private String 	goods_gubun;
	private String 	goods_gubun_nm;
	private String 	goods_code;
	private String 	goods_name;
	private String 	period_mm;
	private String 	mangi_date;
	private String 	iyul;
	private String 	baseprice;
	private String 	exchangeprice;
	private String 	stockprice;
}
