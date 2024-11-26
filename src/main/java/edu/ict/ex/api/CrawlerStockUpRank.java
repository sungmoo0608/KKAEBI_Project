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
public class CrawlerStockUpRank {

    private static final String URL = "https://finance.naver.com/";

    public List<StockTradeRankVO> scrapeStockUpRank() {
    	
        List<StockTradeRankVO> scrape = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            
            // id="_topItems2"인 tbody 태그 선택
            Element tbody = doc.select("tbody#_topItems2").first(); 

            // tbody 내의 모든 tr 태그 (각 종목의 데이터)
            Elements rows = tbody.select("tr");

            for (Element row : rows) {
            	StockTradeRankVO vo = new StockTradeRankVO();
            	
            	// 종목명 (a 태그 내 텍스트)
                vo.setStockName(row.select("th a").text());
                
                // 현재가 (첫 번째 <td> 텍스트)
                Elements tdElements = row.select("td");

                // 전일 대비 (두 번째 <td> 텍스트, 상승/하락 상태 포함)
                if (tdElements.size() > 0) {
                    vo.setStockPrice(tdElements.get(0).text());
                }

                // 전일대비 (두 번째 <td>)
                if (tdElements.size() > 1) {
                    vo.setCrease(tdElements.get(1).text());
                }

                // 등락률 (세 번째 <td>)
                if (tdElements.size() > 2) {
                    vo.setVariance(tdElements.get(2).text());
                }

                // 리스트에 추가
                scrape.add(vo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scrape;
    }
	    
}
    
    