package com.ysn.predictprice.service;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.entities.StockPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


@Service
public class StockService {

    @Autowired
    StockPredictionRepository repository;

    public List<StockPrediction> predictStock(){
        List<StockPrediction> stocks = (List<StockPrediction>) repository.findAll();
        return stocks;
    }

    public List<?> queryPrediction(String ticker) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stock_prediction");
        EntityManager em = emf.createEntityManager();
        List<?> prices = em.createQuery("SELECT s.predict_date,s.prediction_today FROM StockPrediction s where s.ticker=:ticker")
                .setParameter("ticker", ticker)
                .getResultList();
        return prices;
    }

    public List<?> queryReal(String ticker) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stock_prediction");
        EntityManager em = emf.createEntityManager();
        List<?> prices = em.createQuery("SELECT s.yesterday_date,s.price_yesterday FROM StockPrediction s where s.ticker=:ticker")
                .setParameter("ticker", ticker)
                .getResultList();
        return prices;
    }

}