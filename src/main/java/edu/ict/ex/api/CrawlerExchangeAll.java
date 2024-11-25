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
public class CrawlerExchangeAll {

    private static final String URL = "https://finance.naver.com/marketindex/exchangeList.naver";

    public List<ExchangeAllVO> scrapeExchangeAll() {
    	
        List<ExchangeAllVO> scrape = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements rows = doc.select("table.tbl_exchange tbody tr");

            for (Element row : rows) {
            	ExchangeAllVO vo = new ExchangeAllVO();
                vo.setBasedate(row.select(".tit").text());
                vo.setBaseRate(row.select(".sale").get(0).text());
                vo.setBuyCash(row.select("td").get(2).text());
                vo.setSellCash(row.select("td").get(3).text());
                vo.setBuyTransfer(row.select("td").get(4).text());
                vo.setSellTransfer(row.select("td").get(5).text());
                vo.setRate(row.select("td").get(6).text());
                
                scrape.add(vo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scrape;
    }
	    
}
    
    