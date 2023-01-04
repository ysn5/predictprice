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
            "GROUP BY ticker\n" +
            ")sm ON s.ticker = sm.ticker AND s.predict_date=sm.lastdate\n" +
            "LEFT JOIN stock_symbols ci\n" +
            "ON ci.ticker = s.ticker\n" +
            "WHERE s.ticker='GOOGL' or s.ticker='AMZN' or s.ticker='AAPL' or s.ticker='MSFT' or s.ticker='TSLA' or s.ticker='NVDA' or s.ticker='PEP' or s.ticker='AVGO' or s.ticker='AZN' or s.ticker='COST' or s.ticker='CSCO' or s.ticker='ADBE' or s.ticker='CMCSA' or s.ticker='TXN' or s.ticker='AMGN' or s.ticker='NFLX' or s.ticker='QCOM' or s.ticker='SNY' or s.ticker='INTU' or s.ticker='PDD' or s.ticker='INTC' or s.ticker='GILD' or s.ticker='ADP' or s.ticker='AMAT'\n"
            , nativeQuery = true)
    List<StockPrediction> topListFromLastOnes();
}