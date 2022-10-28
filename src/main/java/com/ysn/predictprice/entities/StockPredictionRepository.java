package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    @Query(value = "SELECT predict_date,s.ticker,accuracy,ci.longname as company_name,consensus,predict_time,prediction_today,price_yesterday,predicted_change_rate,yesterday_date,status\n" +
            "FROM stock_prediction s\n" +
            "INNER JOIN(\n" +
            "SELECT ticker, MAX(predict_date) AS lastdate\n" +
            "FROM stock_prediction\n" +
            "GROUP BY ticker\n" +
            ")sm ON s.ticker = sm.ticker AND s.predict_date=sm.lastdate\n" +
            "INNER JOIN company_info ci\n" +
            "ON ci.ticker = s.ticker", nativeQuery = true)
    List<StockPrediction> listFromLastOnes();
}