package com.ysn.predictprice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Stock {

    @JsonFormat(pattern = "yyyy/MM/dd")
    @JsonProperty("predict_date")
    private Date predict_date;
    private Integer id;
    private String ticker;
    private String company_name;
    private Double price_yesterday;
    private Double prediction_today;
    private Float accuracy;
    private String consensus;
}