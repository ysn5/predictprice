package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    /*@Query(value = "SELECT predict_date,s.ticker,accuracy,ci.company_name as company_name,consensus,predict_time,prediction_today,price_yesterday,predicted_change_rate,yesterday_date,status\n" +
            "FROM stock_prediction s\n" +
            "INNER JOIN(\n" +
            "SELECT ticker, MAX(predict_date) AS lastdate\n" +
            "FROM stock_prediction\n" +
            "GROUP BY ticker\n" +
            ")sm ON s.ticker = sm.ticker AND s.predict_date=sm.lastdate\n" +
            "LEFT JOIN stock_symbols ci\n" +
            "ON ci.ticker = s.ticker\n" +
            "WHERE s.predict_date >= CURDATE()-3 and s.ticker!='GOOGL' and s.ticker!='AMZN' and s.ticker!='AAPL' and s.ticker!='MSFT' and s.ticker!='TSLA' and s.ticker!='NVDA' and s.ticker!='PEP' and s.ticker!='AVGO' and s.ticker!='AZN' and s.ticker!='COST' and s.ticker!='CSCO' and s.ticker!='ADBE' and s.ticker!='CMCSA' and s.ticker!='TXN' and s.ticker!='AMGN' and s.ticker!='NFLX' and s.ticker!='QCOM' and s.ticker!='SNY' and s.ticker!='INTU' and s.ticker!='PDD' and s.ticker!='INTC' and s.ticker!='GILD' and s.ticker!='ADP' and s.ticker!='AMAT' order by s.ticker asc\n"
            , nativeQuery = true)*/
    
     @Query(value = "SELECT \r\n"
     		+ "    s.predict_date,\r\n"
     		+ "    s.ticker,\r\n"
     		+ "    ci.company_name,\r\n"
     		+ "    s.accuracy,\r\n"
     		+ "    s.consensus,\r\n"
     		+ "    s.predict_time,\r\n"
     		+ "    s.prediction_today,\r\n"
     		+ "    s.price_yesterday,\r\n"
     		+ "    s.predicted_change_rate,\r\n"
     		+ "    s.yesterday_date,\r\n"
     		+ "    s.STATUS\r\n"
     		+ "FROM \r\n"
     		+ "    stock_prediction s \r\n"
     		+ "    LEFT JOIN stock_symbols ci ON ci.ticker = s.ticker\r\n"
     		+ "WHERE \r\n"
     		+ "    s.predict_date IN (SELECT MAX(predict_date) FROM stock_prediction) \r\n"
     		+ "	 AND s.ticker NOT IN (\r\n"
     		+ "        'GOOGL', 'AMZN', 'AAPL', 'MSFT', 'TSLA', 'NVDA', 'PEP', 'AVGO', 'AZN', \r\n"
     		+ "        'COST', 'CSCO', 'ADBE', 'CMCSA', 'TXN', 'AMGN', 'NFLX', 'QCOM', 'SNY', \r\n"
     		+ "        'INTU', 'PDD', 'INTC', 'GILD', 'ADP', 'AMAT'\r\n"
     		+ "    )\r\n"
     		+ "ORDER BY \r\n"
     		+ "    s.ticker ASC"
    		, nativeQuery = true)

    
    List<StockPrediction> listFromLastOnes();
}