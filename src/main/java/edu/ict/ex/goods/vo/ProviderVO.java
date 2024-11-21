package edu.ict.ex.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름            널?       유형            
//------------- -------- ------------- 
//PROVIDER_CODE NOT NULL NUMBER(4)     
//PROVIDER_NAME          VARCHAR2(100) 
//STATUS                 NUMBER(2)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProviderVO {
	
	private int provider_code;
	private String provider_name;
	private int status;

}
