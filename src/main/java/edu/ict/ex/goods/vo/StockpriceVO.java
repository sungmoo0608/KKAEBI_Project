package edu.ict.ex.goods.vo;

import java.util.Date;

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
//TRAN_DATETIME          DATE         
//STOCK_PRICE   NOT NULL NUMBER(10,3) 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class StockpriceVO {
	
	private int goods_code;
	private String base_date;
	private int seq_no;
	private int status;
	private Date tran_datetime;
	private int stock_price;
}
