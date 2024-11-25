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

public class ExchangeUSDVO {
	
    private String basedate;
    private String baseRate;
    private String compare;
    private String buyCash;
    private String sellCash;
    private String buyTransfer;
    private String sellTransfer;
	
}
