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
    public Float prediction_today;

    @Column(nullable = true)
    public Float accuracy;

    @Column(length = 30, nullable = true)
    public String consensus;

    @Column(nullable = true)
    public Timestamp predict_time;
    //Java Timestamp -> Mysql Datetime
    //Java Date -> Mysql Date

    @Builder
    public StockPrediction(String company_name, Float price_yesterday, Float prediction_today, Float accuracy, String consensus, Timestamp predict_time) {
        this.company_name = company_name;
        this.price_yesterday = price_yesterday;
        this.prediction_today = prediction_today;
        this.accuracy = accuracy;
        this.consensus = consensus;
        this.predict_time = predict_time;
    }

    public StockPrediction(){

    }
}