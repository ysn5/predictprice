package com.ysn.predictprice.controllers;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(path = "/predictstock")
    public String predictstock(Model model){
        List<StockPrediction> predictstock = stockService.predictStock();
        model.addAttribute("predictstock", predictstock);
        return "contents/predictstock";
    }


}