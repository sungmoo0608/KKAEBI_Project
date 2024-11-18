package edu.ict.ex.simulation.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//이름          널?       유형             
//----------- -------- -------------- 
//FIN_CO_NO   NOT NULL NUMBER(5)      
//FIN_PRDT_CD NOT NULL VARCHAR2(50)   
//KOR_CO_NM   NOT NULL VARCHAR2(100)  
//FIN_PRDT_NM NOT NULL VARCHAR2(200)  
//JOIN_WAY             VARCHAR2(100)  
//MTRT_INT             VARCHAR2(1000) 
//SPCL_CND             VARCHAR2(1000) 
//JOIN_DENY            NUMBER(2)      
//JOIN_MEMBER          VARCHAR2(200)  
//ETC_NOTE             VARCHAR2(500)  
//MAX_LIMIT            NUMBER(10)     


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FinProductVO  {
	
    private int fin_co_no;
    private String fin_prdt_cd;
    private String kor_co_nm;
    private String fin_prdt_nm;
    private String join_way;
    private String mtrt_int;
    private String spcl_cnd;
    private int join_deny;
    private String join_member;
    private String etc_note;
    private long max_limit;

}
