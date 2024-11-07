package edu.ict.ex.simulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.simulation.mapper.FinProductMapper;
import edu.ict.ex.simulation.vo.FinProductVO;
import edu.ict.ex.simulation.vo.join.FinProductOptionVO;

@Service
public class FinProductService {

    @Autowired
    private FinProductMapper finProductMapper;
    
    public List<FinProductVO> getFinProductList() {
    	System.out.println("getFinProductList() ..");
        return finProductMapper.getFinProductList();
    }
    
	//조인 처리 - 추천 방법
	public List<FinProductOptionVO> getFinProductOption() {
		return finProductMapper.getFinProductOption();
	}
}