package com.ysn.predictprice.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "stock_prediction")
@IdClass(StockPredictionId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockPrediction {

    @Id
    private String ticker;

    @Id
    private Date predict_date;

    @Column(length = 255)
    private String company_name;

    private Float price_yesterday;
    private Date yesterday_date;
    private Float prediction_today;
    private Float accuracy;

    @Column(length = 30)
    private String consensus;

    private Timestamp predict_time;
    private Float predicted_change_rate;
    private Integer status;

    @Transient
    private String detailLink;
}
