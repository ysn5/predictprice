package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopStockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    @Query(value = "SELECT predict_date,s.ticker,accuracy,ci.company_name as company_name,consensus,predict_time,prediction_today,price_yesterday,predicted_change_rate,yesterday_date,status\n" +
            "FROM stock_prediction s\n" +
            "INNER JOIN(\n" +
            "SELECT ticker, MAX(predict_date) AS lastdate\n" +
            "FROM stock_prediction\n" +
            "WHERE ticker='GOOGL' or ticker='AMZN' or ticker='AAPL' or ticker='MSFT' or ticker='TSLA' or ticker='NVDA' or ticker='PEP' or ticker='AVGO' or ticker='AZN' or ticker='COST' or ticker='CSCO' or ticker='ADBE' or ticker='CMCSA' or ticker='TXN' or ticker='AMGN' or ticker='NFLX' or ticker='QCOM' or ticker='SNY' or ticker='INTU' or ticker='PDD' or ticker='INTC' or ticker='GILD' or ticker='ADP' or ticker='AMAT'\n"+
            "GROUP BY ticker\n" +
            ")sm ON s.ticker = sm.ticker AND s.predict_date=sm.lastdate\n" +
            "LEFT JOIN stock_symbols ci\n" +
            "ON ci.ticker = s.ticker", nativeQuery = true)
    List<StockPrediction> topListFromLastOnes();
}