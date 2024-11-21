package edu.ict.ex.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//이름            널?       유형           
//------------- -------- ------------ 
//GOODS_CODE    NOT NULL NUMBER(10)   
//BASE_DATE     NOT NULL VARCHAR2(8)  
//SEQ_NO        NOT NULL NUMBER(10)   
//STATUS        NOT NULL NUMBER(2)    
//EXCHANGE_RATE NOT NULL NUMBER(10,3) 


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ExchangerateVO {
	
	private int goods_code;
	private String base_date;
	private int seq_no;
	private int status;
	private double exchange_rate;
}
