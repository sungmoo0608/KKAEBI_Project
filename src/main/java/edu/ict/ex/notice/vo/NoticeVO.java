package edu.ict.ex.notice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름              널?       유형             
//--------------- -------- -------------- 
//SEQ_NO          NOT NULL NUMBER(10)     
//NOTICE_TITLE             VARCHAR2(500)  
//NOTICE_CONTENT           VARCHAR2(3000) 
//NOTICE_TARGET            NUMBER(2)      
//NOTICE_ST_DATE           VARCHAR2(8)    
//NOTICE_END_DATE          VARCHAR2(8)    
//STATUS                   NUMBER(2)      
//REGIST_ID                VARCHAR2(50)   
//REGIST_DATE              VARCHAR2(8)    
//LAST_CHG_ID              VARCHAR2(50)   
//LAST_CHG_DATE            VARCHAR2(8)    
//EXPIRE_ID                VARCHAR2(50)   
//EXPIRE_DATE              VARCHAR2(8)    

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class NoticeVO {

	private int seq_no;
	private String notice_title;
	private String notice_content;
	private int notice_target;
	private String notice_st_date;
	private String notice_end_date;
	private int status;
	private String regist_id;
	private String regist_date;
	private String last_chg_id;
	private String last_chg_date;
	private String expire_id;
	private String expire_date;

}