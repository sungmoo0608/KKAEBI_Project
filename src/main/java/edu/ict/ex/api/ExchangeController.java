package edu.ict.ex.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;
	
    @GetMapping("/exchangeall")
    public ResponseEntity<List<ExchangeAllVO>> scrapeExchangeAll() {
        List<ExchangeAllVO> all = exchangeService.scrapeExchangeAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/usdkrw")
    public ResponseEntity<List<ExchangeUSDVO>> scrapeExchangeUSD() {
        List<ExchangeUSDVO> rates = exchangeService.scrapeExchangeUSD();
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/stocktrade")
    public ResponseEntity<List<StockTradeRankVO>> scrapeStockTradeRank() {
        List<StockTradeRankVO> stockTrade = exchangeService.scrapeStockTradeRank();
        return ResponseEntity.ok(stockTrade);
    }
    
    @GetMapping("/stockuprank")
    public ResponseEntity<List<StockTradeRankVO>> scrapeStockUpRank() {
        List<StockTradeRankVO> stockTrade = exchangeService.scrapeStockUpRank();
        return ResponseEntity.ok(stockTrade);
    }
    
    @GetMapping("/stockdownrank")
    public ResponseEntity<List<StockTradeRankVO>> scrapeStockDownRank() {
        List<StockTradeRankVO> stockTrade = exchangeService.scrapeStockDownRank();
        return ResponseEntity.ok(stockTrade);
    }
    
}
