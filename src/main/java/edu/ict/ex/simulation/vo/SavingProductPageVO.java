package edu.ict.ex.simulation.vo;

import java.util.List;

import edu.ict.ex.simulation.page.PageVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//적금 상품 리스트
//이름         널?       유형             
//---------- -------- -------------- 
//FINCONO    NOT NULL NUMBER(5)      
//FINPRDTCD  NOT NULL VARCHAR2(50)   
//KORCONM    NOT NULL VARCHAR2(100)  
//FINPRDTNM  NOT NULL VARCHAR2(200)  
//JOINWAY             VARCHAR2(100)  
//MTRTINT             VARCHAR2(1000) 
//SPCLCND             VARCHAR2(1000) 
//JOINDENY            NUMBER(2)      
//JOINMEMBER          VARCHAR2(200)  
//ETCNOTE             VARCHAR2(500)  
//MAXLIMIT            NUMBER(10)        


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SavingProductPageVO  {
 
    private List<SavingProductVO> product;
    private PageVO page;
    
}
