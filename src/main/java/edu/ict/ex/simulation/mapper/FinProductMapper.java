package edu.ict.ex.simulation.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import edu.ict.ex.simulation.vo.FinProductVO;
import edu.ict.ex.simulation.vo.join.FinProductOptionVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@MapperScan("edu.ict.ex.simulation.mapper")
public interface FinProductMapper  {
	
	public List<FinProductVO> getFinProductList();
	
	List<FinProductOptionVO> getFinProductOption();
	
}
