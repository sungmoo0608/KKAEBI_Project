package edu.ict.ex.simulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.simulation.mapper.SavingProductMapper;
import edu.ict.ex.simulation.page.Criteria;
import edu.ict.ex.simulation.vo.SavingProductVO;
import edu.ict.ex.simulation.vo.join.SavingProductOptionVO;

@Service
public class SavingProductService {

    @Autowired
    private SavingProductMapper savingProductMapper;
    
    public List<SavingProductVO> getSavingProductList() {
    	System.out.println("getSavingProductList() ..");
        return savingProductMapper.getSavingProductList();
    }
    
	public SavingProductVO get(String finprdtcd) {
		
		System.out.println("get()..");
		
		SavingProductVO savingProduct = new SavingProductVO();
		savingProduct.setFinprdtcd(finprdtcd);
		
		return savingProductMapper.read(finprdtcd);
	}
	
	public int getTotal() {            
		return savingProductMapper.getTotalCount();
	}


	public List<SavingProductVO> getListWithPaging(Criteria cri) {      
		return savingProductMapper.getListWithPaging(cri);
	}
	
	//조인 처리 - 추천 방법
	public List<SavingProductOptionVO> getSavingProductOptionList() {
		return savingProductMapper.getSavingProductOptionList();
	}
    
    
}