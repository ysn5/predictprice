package com.ysn.predictprice.entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stock_prediction")
@IdClass(StockPredictionId.class)
@Entity
public class StockPrediction {

    @Id
    private String ticker;
    public String getTicker() {   // Ensure getter exists
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Id
    @Column(name = "predict_date") 
    private Date predictDate;
    public Date getPredictDate() {
    	return predictDate;
    }

    @Column(name = "company_name", length = 255, nullable = true)
    private String companyName; // Make sure this matches

    public String getCompanyName() { // Ensure this getter exists
        return companyName;
    }

    @Column(name="price_yesterday", nullable = true)
    private Float priceYesterday;
    public Float getPriceYesterday() {
    	return priceYesterday;
    }

    @Column(name="yesterday_date", nullable = true)
    private Date yesterdayDate;
    public Date getYesterdayDate() {
    	return yesterdayDate;
    }

    @Column(name="prediction_today", nullable = true)
    private Float predictionToday;
    public Float getPredictionToday() {
    	return predictionToday;
    }

    @Column(name="accuracy", nullable = true)
    private Float accuracy;
    public Float getAccuracy() {
    	return accuracy;
    }

    @Column(name="consensus", length = 30, nullable = true)
    private String consensus;
    public String getConsensus() {
    	return consensus;
    }

    @Column(name="predict_time", nullable = true)
    private Timestamp predictTime;
    public Timestamp getPredictTime() {
    	return predictTime;
    }

    @Column(name="predicted_change_rate", nullable = true)
    private Float predictedChangeRate;
    public Float getPredictedChangeRate() {
    	return predictedChangeRate;
    }

    @Column(name="status", nullable = true)
    private Integer status;
    public Integer getStatus() {
    	return status;
    }
    
    @Column(name="priority", nullable = true)
    private Integer priority;
    public Integer getPriority() {
    	return priority;
    }

    @Transient
    private String detailLink;
    public String getDetailLink() {
    	return detailLink;
    }
}
