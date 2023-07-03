package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    @Query(value = "SELECT predict_date,s.ticker,accuracy,ci.company_name as company_name,consensus,predict_time,prediction_today,price_yesterday,predicted_change_rate,yesterday_date,status\n" +
            "FROM stock_prediction s\n" +
            "INNER JOIN(\n" +
            "SELECT ticker, MAX(predict_date) AS lastdate\n" +
            "FROM stock_prediction\n" +
            "GROUP BY ticker\n" +
            ")sm ON s.ticker = sm.ticker AND s.predict_date=sm.lastdate\n" +
            "LEFT JOIN stock_symbols ci\n" +
            "ON ci.ticker = s.ticker\n" +
            "WHERE s.predict_date >= CURDATE() - INTERVAL 5 DAY AND s.ticker!='GOOGL' and s.ticker!='AMZN' and s.ticker!='AAPL' and s.ticker!='MSFT' and s.ticker!='TSLA' and s.ticker!='NVDA' and s.ticker!='PEP' and s.ticker!='AVGO' and s.ticker!='AZN' and s.ticker!='COST' and s.ticker!='CSCO' and s.ticker!='ADBE' and s.ticker!='CMCSA' and s.ticker!='TXN' and s.ticker!='AMGN' and s.ticker!='NFLX' and s.ticker!='QCOM' and s.ticker!='SNY' and s.ticker!='INTU' and s.ticker!='PDD' and s.ticker!='INTC' and s.ticker!='GILD' and s.ticker!='ADP' and s.ticker!='AMAT' order by s.ticker asc\n"
            , nativeQuery = true)
    List<StockPrediction> listFromLastOnes();
}