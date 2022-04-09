package com.ysn.predictprice.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
//@Repository
//public interface StockPredictionRepository extends JpaRepository<Stock, StockPredictionId>{

    //@Modifying
    //@Transactional
    //@Query(value="UPDATE predictpricetest.stock_prediction p SET m.name=:#{#product.name}, m.memo=:#{#product.memo}, m.price=:#{#product.price} WHERE m.id = :id", nativeQuery=true)
    //void update(@Param("product") Product product, @Param("id") Long id);
//}

@Repository
public interface StockPredictionRepository
        extends JpaRepository<StockPrediction, Long> {

}