package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPredictionRepository extends JpaRepository<StockPrediction, Long> {
    
     @Query(value = "SELECT \r\n"
     		+ "    s.predict_date,\r\n"
     		+ "    s.ticker,\r\n"
     		+ "    s.company_name,\r\n"
     		+ "    s.accuracy,\r\n"
     		+ "    s.consensus,\r\n"
     		+ "    s.predict_time,\r\n"
     		+ "    s.prediction_today,\r\n"
     		+ "    s.price_yesterday,\r\n"
     		+ "    s.predicted_change_rate,\r\n"
     		+ "    s.yesterday_date,\r\n"
     		+ "    s.STATUS,\r\n"
     		+ "    s.priority\r\n"
     		+ "FROM \r\n"
     		+ "    stock_prediction s \r\n"
     		+ "WHERE \r\n"
     		+ "    s.predict_date IN (SELECT MAX(predict_date) FROM stock_prediction) \r\n"
     		+ "ORDER BY \r\n"
     		+ "    s.priority DESC, s.ticker ASC"
    		, nativeQuery = true)

    
    List<StockPrediction> listFromLastOnes();
}