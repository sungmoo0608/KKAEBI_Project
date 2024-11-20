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

public class GoodsStockpriceProviderVO {
	
	private GoodsVO goods;
	private StockpriceVO stockprice;
	private ProviderVO provider;

}
