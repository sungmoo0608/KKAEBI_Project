package edu.ict.ex.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    @Autowired
    private CrawlerExchangeUSD crawlerExchangeUSD;

    public List<ExchangeUSDVO> scrapeExchangeUSD() {
        return crawlerExchangeUSD.scrapeExchangeUSD();
    }
    
    @Autowired
    private CrawlerExchangeAll crawlerExchangeAll;
    
    public List<ExchangeAllVO> scrapeExchangeAll() {
        return crawlerExchangeAll.scrapeExchangeAll();
    }
    
    @Autowired
    private CrawlerStockTradeRank crawlerStockTradeRank;
    
    public List<StockTradeRankVO> scrapeStockTradeRank() {
        return crawlerStockTradeRank.scrapeStockTradeRank();
    }
    
    @Autowired
    private CrawlerStockUpRank crawlerStockUpRank;
    
    public List<StockTradeRankVO> scrapeStockUpRank() {
        return crawlerStockUpRank.scrapeStockUpRank();
    }
    
    
    @Autowired
    private CrawlerStockDownRank crawlerStockDownRank;
    
    public List<StockTradeRankVO> scrapeStockDownRank() {
        return crawlerStockDownRank.scrapeStockDownRank();
    }
    
    
}
