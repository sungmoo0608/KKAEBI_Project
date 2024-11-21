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

public class GoodsAllVO {
	
	private GoodsVO goods;
	private BasepriceVO baseprice;
	private ExchangerateVO exchangerate;
	private InterestrateVO interestrate;	
	private ProviderVO provider;
	private StockpriceVO stockprice;
	
}
