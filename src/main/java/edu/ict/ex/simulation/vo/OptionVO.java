package edu.ict.ex.simulation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름                널?       유형           
//----------------- -------- ------------ 
//FIN_PRDT_CD       NOT NULL VARCHAR2(50) 
//INTR_RATE_TYPE    NOT NULL VARCHAR2(1)  
//INTR_RATE_TYPE_NM NOT NULL VARCHAR2(50) 
//RSRV_TYPE         NOT NULL VARCHAR2(1)  
//RSRV_TYPE_NM      NOT NULL VARCHAR2(50) 
//SAVE_TRM          NOT NULL NUMBER(3)    
//INTR_RATE         NOT NULL NUMBER(5,2)  
//INTR_RATE2                 NUMBER(5,2)  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OptionVO  {
	
    private String fin_prdt_cd;
    private String intr_rate_type;
    private String intr_rate_type_nm;
    private String rsrv_type;
    private String rsrv_type_nm;
    private int save_trm;
    private double intr_rate;
    private double intr_rate2;
	
}
