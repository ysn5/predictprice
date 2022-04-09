package com.ysn.predictprice.service;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.entities.StockPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StockService {

    @Autowired
    StockPredictionRepository repository;

    public List<StockPrediction> predictStock(){
        List<StockPrediction> stocks = (List<StockPrediction>) repository.findAll();
        return stocks;
    }

}