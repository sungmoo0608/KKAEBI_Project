package edu.ict.ex.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름            널?       유형           
//------------- -------- ------------ 
//GOODS_CODE    NOT NULL NUMBER(10)   
//PERIOD_MM     NOT NULL NUMBER(10)   
//STATUS        NOT NULL NUMBER(1)    
//INTEREST_RATE          NUMBER(10,3) 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class InterestrateVO {
	
	private int goods_code;
	private int period_mm;
	private int status;
	private double interest_rate;
}
