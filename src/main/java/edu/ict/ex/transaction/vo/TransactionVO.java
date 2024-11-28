package edu.ict.ex.transaction.vo;

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
public class TransactionVO {
	private String 	user_id;
	private String 	name;
	private String 	account_no;
	private String 	tr_seqno;
	private String 	goods_gubun;
	private String 	goods_gubun_nm;
	private String 	goods_code;
	private String 	goods_name;
	private String 	provider_code;
	private String 	provider_nm;
	private String 	tran_unit;
	private String 	period_mm;
	private String 	invest_gubun;
	private String 	mangi_date;
	private String 	curprice;
	private String 	ija_amt;
	private String 	tr_number;
	private String 	trforign_amt;
	private String 	tr_amt;
	private String 	haeji_amt;
	
}
