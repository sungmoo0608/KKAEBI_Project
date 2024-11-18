package edu.ict.ex.simulation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//적금 상품 이자율
//이름             널?       유형           
//-------------- -------- ------------ 
//FINPRDTCD      NOT NULL VARCHAR2(50) 
//INTRRATETYPE   NOT NULL VARCHAR2(1)  
//INTRRATETYPENM NOT NULL VARCHAR2(50) 
//SAVETRM        NOT NULL NUMBER(3)    
//INTRRATE       NOT NULL NUMBER(5,2)  
//INTRRATE2               NUMBER(5,2)  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SavingProductRatesVO  {
	
    private String finprdtcd;
    private String intrratetype;
    private String intrratetypenm;
    private int savetrm;
    private double intrrate;
    private double intrrate2;
	
}
