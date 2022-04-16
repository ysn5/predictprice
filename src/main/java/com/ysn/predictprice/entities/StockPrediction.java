package com.ysn.predictprice.entities;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "stock_prediction")
@IdClass(StockPredictionId.class)
public class StockPrediction {

    //for compoisted key embeded way in StockPredictionId
    //@EmbeddedId
    //public StockPredictionId stockPredictionId;

    @Id
    public String ticker;
    @Id
    public Date predict_date;

    @Column(length = 255, nullable = true)
    public String company_name;

    @Column(nullable = true)
    public Float price_yesterday;

    @Column(nullable = true)
    public Date yesterday_date;

    @Column(nullable = true)
    public Float prediction_today;

    @Column(nullable = true)
    public Float accuracy;

    @Column(length = 30, nullable = true)
    public String consensus;

    @Column(nullable = true)
    public Timestamp predict_time;
    //Java Timestamp -> Mysql Datetime
    //Java Date -> Mysql Date

    @Column(nullable = true)
    public Float predicted_change_rate;

    @Column(nullable = true)
    public Integer status;

    @Transient
    private String detailLink;

    @Builder
    public StockPrediction(String ticker, Date predict_date, String company_name, Float price_yesterday, Date yesterday_date, Float prediction_today, Float accuracy, String consensus, Timestamp predict_time, Float predicted_change_rate, Integer status) {
        this.ticker = ticker;
        this.predict_date = predict_date;
        this.company_name = company_name;
        this.price_yesterday = price_yesterday;
        this.yesterday_date = yesterday_date;
        this.prediction_today = prediction_today;
        this.accuracy = accuracy;
        this.consensus = consensus;
        this.predict_time = predict_time;
        this.predicted_change_rate = predicted_change_rate;
        this.status = status;
    }

    public StockPrediction(){

    }
}