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
//STATUS        NOT NULL NUMBER(2)    
//TRBASE_PRICE  NOT NULL NUMBER(10,3) 
//TRXBASE_PRICE NOT NULL NUMBER(10,3) 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BasepriceVO {
	
	private int goods_code;
	private String base_date;
	private int status;
	private double trbase_price;
	private double trxbase_price;
	
}
