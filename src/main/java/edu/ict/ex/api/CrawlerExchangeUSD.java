package edu.ict.ex.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component; 

@Component
public class CrawlerExchangeUSD {

    private static final String URL = "https://finance.naver.com/marketindex/exchangeDailyQuote.nhn?marketindexCd=FX_USDKRW";

    public List<ExchangeUSDVO> scrapeExchangeUSD() {
    	
        List<ExchangeUSDVO> scrape = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements rows = doc.select("table.tbl_exchange tbody tr");

            for (Element row : rows) {
                ExchangeUSDVO vo = new ExchangeUSDVO();
                vo.setBasedate(row.select(".date").text());
                vo.setBaseRate(row.select(".num").get(0).text());
                vo.setCompare(row.select(".num").get(1).text());
                vo.setBuyCash(row.select("td").get(3).text());
                vo.setSellCash(row.select("td").get(4).text());
                vo.setBuyTransfer(row.select("td").get(5).text());
                vo.setSellTransfer(row.select("td").get(6).text());
                
                scrape.add(vo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scrape;
    }
	    
}
    
    