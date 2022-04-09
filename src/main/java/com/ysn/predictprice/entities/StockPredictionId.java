package com.ysn.predictprice.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class StockPredictionId implements Serializable {

    @Id
    @Column(name="ticker",length=30)
    public String ticker;

    @Id
    @Column(name="predict_date")
    public Date predict_date;

    public StockPredictionId(){ }

    public StockPredictionId(String ticker,Date predict_date){
        this.ticker = ticker;
        this.predict_date = predict_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPredictionId that = (StockPredictionId) o;
        return Objects.equals(ticker, that.ticker) && Objects.equals(predict_date, that.predict_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, predict_date);
    }
}