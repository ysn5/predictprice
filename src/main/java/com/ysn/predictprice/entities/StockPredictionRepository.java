package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    @Query(value = "SELECT predict_date,s.ticker as ticker,accuracy,company_name,consensus,predict_time,prediction_today,price_yesterday,predicted_change_rate,yesterday_date,status FROM stock_prediction s INNER JOIN( SELECT ticker AS tick, max(predict_date) AS lastdate FROM stock_prediction GROUP BY tick ) sm ON s.ticker = sm.tick AND s.predict_date=sm.lastdate", nativeQuery = true)
    List<StockPrediction> listFromLastOnes();
}