package com.ysn.predictprice.controllers;

import com.ysn.predictprice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String list(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
        model.addAttribute("stocks", stockService.getStocks(pageNumber, size));
        return "contents/stock";
    }
}