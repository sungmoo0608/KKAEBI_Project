package edu.ict.ex.api;

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

public class StockTradeRankVO {
	
    private String stockName;
    private String stockPrice;
    private String crease;
    private String variance;
	
}
