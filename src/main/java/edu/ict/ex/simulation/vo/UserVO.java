package edu.ict.ex.simulation.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* 
이름         널?       유형            
---------- -------- ------------- 
USERID     NOT NULL VARCHAR2(50)  
PASSWORD   NOT NULL VARCHAR2(100) 
UNAME               VARCHAR2(50)  
UTEL                VARCHAR2(50)  
ZIPCODE             VARCHAR2(50)  
UADR                VARCHAR2(100) 
UADRDETAIL          VARCHAR2(100) 
UEMAIL              VARCHAR2(100) 
ENABLED             CHAR(1)          
*/  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserVO  {
	
	private String userid;
	private String password;
	private String uname;
	private String utel;
	private String zipcode;
	private String uadr;
	private String uadrdetail;
	private String uemail;
	private String enabled;
	
	private List<AuthVO> authList;
}
