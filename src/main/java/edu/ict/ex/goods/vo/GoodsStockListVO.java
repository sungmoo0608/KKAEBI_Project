package edu.ict.ex.goods.vo;

import java.util.List;

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

public class GoodsStockListVO {
	
	private int goods_code;
	private int goods_gubun;
	private int provider_code;
	private String goods_name;
	private String orign_code;
	private int period_mm;
	private int invest_gubun;
	private int forignexg_kind;
	private int tran_unit;
	private int goods_status;
	
	private List<StockpriceVO> stockprice;
	private List<ProviderVO> provider;
	
}
