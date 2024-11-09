package edu.ict.ex.simulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.simulation.mapper.SavingProductMapper;
import edu.ict.ex.simulation.vo.SavingProductRatesVO;
import edu.ict.ex.simulation.vo.SavingProductVO;
import edu.ict.ex.simulation.vo.join.SavingProductOptionVO;

@Service
public class SavingProductService {

    @Autowired
    private SavingProductMapper savingProductMapper;
    
    public List<SavingProductVO> getSavingProductList() {
    	System.out.println("getFinProductList() ..");
        return savingProductMapper.getSavingProductList();
    }
    
	public SavingProductVO get(String pcd) {
		
		System.out.println("get()..");
		
		SavingProductVO savingProduct = new SavingProductVO();
		savingProduct.setFinprdtcd(pcd);
		
		return savingProductMapper.read(pcd);
	}
    
	//조인 처리 - 추천 방법
	public List<SavingProductRatesVO> getSavingProductOptionList() {
		return savingProductMapper.getSavingProductOptionList();
	}
    
    
}