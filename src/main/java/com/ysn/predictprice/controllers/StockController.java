package com.ysn.predictprice.controllers;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/predictiondetail", method = RequestMethod.GET)
    public String predictiondetail(HttpServletRequest request, Model model) throws ParseException {
        model.addAttribute("ticker", request.getParameter("ticker"));
        return "contents/predictiondetail";
    }

}