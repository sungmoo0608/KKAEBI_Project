package edu.ict.ex.simulation.vo.join;

import edu.ict.ex.simulation.vo.SavingProductRatesVO;
import edu.ict.ex.simulation.vo.SavingProductVO;
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

public class SavingProductOptionVO  {
	
	private SavingProductVO savingProduct;
	private SavingProductRatesVO savingProductRates;

}
