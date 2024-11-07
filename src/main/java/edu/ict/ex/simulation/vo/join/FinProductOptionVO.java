package edu.ict.ex.simulation.vo.join;

import edu.ict.ex.simulation.vo.FinProductVO;
import edu.ict.ex.simulation.vo.OptionVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FinProductOptionVO  {
	
	private FinProductVO finProduct;
	private OptionVO option;

}
