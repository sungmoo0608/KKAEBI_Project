package edu.ict.ex.simulation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.simulation.page.Criteria;
import edu.ict.ex.simulation.vo.SavingProductVO;
import edu.ict.ex.simulation.vo.join.SavingProductOptionVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface SavingProductMapper  {
	
	SavingProductVO read(String finprdtcd);
	
	//페이징 관련
	int getTotalCount();
	List<SavingProductVO> getListWithPaging(Criteria cri);

	public List<SavingProductVO> getSavingProductList();
	
	//연습문제 join 처리 추천 방법
	List<SavingProductOptionVO> getSavingProductOptionList();
	
	
	
}
