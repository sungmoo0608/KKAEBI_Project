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

public class GoodsBasepriceProviderVO {
	
	private GoodsVO goods;
	private BasepriceVO baseprice;
	private ProviderVO provider;

}
