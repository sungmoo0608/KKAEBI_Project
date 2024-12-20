package edu.ict.ex.user.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* 
이름               널?       유형            
---------------- -------- ------------- 
USER_ID          NOT NULL VARCHAR2(50)  
PASSWD           NOT NULL VARCHAR2(100) 
CIF_GUBUN        NOT NULL NUMBER(2)     
BIRTHDAY                  VARCHAR2(10)  
BIZ_NO                    VARCHAR2(10)  
NAME                      VARCHAR2(100) 
TELNO                     VARCHAR2(50)  
EMAIL                     VARCHAR2(50)  
CREATE_DATE               DATE          
LAST_CHANGE_DATE          DATE            
*/  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserVO  {
	
	private String user_id;
	private String passwd;
	private String cif_gubun;
	private String birthday;
	private String biz_no;
	private String name;
	private String telno;
	private String email;
	private String create_date;
	private String last_change_date;
	
	private List<AuthVO> authList;
	
}
