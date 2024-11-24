package edu.ict.ex.notice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//이름             널?       유형             
//-------------- -------- -------------- 
//SEQ_NO         NOT NULL NUMBER(10)     
//GOODS_CODE              NUMBER(10)     
//NOTICE_TITLE            VARCHAR2(500)  
//NOTICE_CONTENT          VARCHAR2(3000) 
//STATUS                  NUMBER(2)      
//REGIST_ID               VARCHAR2(50)   
//REGIST_DATE             VARCHAR2(10)   
//LAST_CHG_DATE           VARCHAR2(10)   
//EXPIRE_ID               VARCHAR2(50)   
//EXPIRE_DATE             VARCHAR2(10)   
//BHIT                    NUMBER(10)     
//BGROUP                  NUMBER(10)     
//BSTEP                   NUMBER(10)     
//BINDENT                 NUMBER(10)     
//STAR_RATING             NUMBER(2)            

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewVO {

	private int seq_no; 
	private int goods_code;
	private String notice_title;
	private String notice_content;
	private int status;
	private String regist_id;
	private String regist_date;
	private String last_chg_date;
	private String expire_id;
	private String expire_date;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private int star_rating;

}
