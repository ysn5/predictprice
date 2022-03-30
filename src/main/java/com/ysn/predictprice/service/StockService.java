package com.ysn.predictprice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysn.predictprice.model.Stock;
import com.ysn.predictprice.paging.Page;
import com.ysn.predictprice.paging.Paged;
import com.ysn.predictprice.paging.Paging;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    public Paged<Stock> getStocks(int pageNumber, int size) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Stock> Stocks = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("jsons/stocks.json"),
                    new TypeReference<List<Stock>>() {
                    });

            List<Stock> paged = Stocks.stream()
                    .skip(pageNumber)
                    .limit(size)
                    .collect(Collectors.toList());

            int totalPages = Stocks.size() / size;
            return new Paged<>(new Page<>(paged, totalPages), Paging.of(totalPages, pageNumber, size));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Paged<>();
    }
}