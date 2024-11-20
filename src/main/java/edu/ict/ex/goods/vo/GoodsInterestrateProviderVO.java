package edu.ict.ex.goods.vo;

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

public class GoodsInterestrateProviderVO {
	
	private GoodsVO goods;
	private InterestrateVO interestRate;
	private ProviderVO provider;

}
