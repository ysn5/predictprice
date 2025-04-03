package com.ysn.predictprice.service;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.entities.StockPredictionRepository;
import com.ysn.predictprice.entities.TopStockPredictionRepository;
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
    public StockPredictionRepository repository;
    @Autowired
    public TopStockPredictionRepository toprepository;

//    public List<StockPrediction> predictStock(){
//        List<StockPrediction> stocks = (List<StockPrediction>) repository.findAll();
//        return stocks;
//    }

    public List<StockPrediction> listFromLastOnes(){
        List<StockPrediction> stocks = (List<StockPrediction>) repository.listFromLastOnes();
        return stocks;
    }

    public List<StockPrediction> topListFromLastOnes(){
        List<StockPrediction> stocks = (List<StockPrediction>) toprepository.topListFromLastOnes();
        return stocks;
    }

    public List<?> queryPrediction(String ticker) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stock_prediction");
        EntityManager em = emf.createEntityManager();
        List<?> prices = em.createQuery("SELECT s.predictDate,s.predictionToday, s.consensus FROM StockPrediction s where s.ticker=:ticker")
                .setParameter("ticker", ticker)
                .setHint("javax.persistence.query.timeout", 1000)
                .getResultList();
        return prices;
    }

    public List<?> queryReal(String ticker) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stock_prediction");
        EntityManager em = emf.createEntityManager();
        List<?> prices = em.createQuery("SELECT s.yesterdayDate,s.priceYesterday FROM StockPrediction s where s.ticker=:ticker")
                .setParameter("ticker", ticker)
                .setHint("javax.persistence.query.timeout", 1000)
                .getResultList();
        return prices;
    }

}