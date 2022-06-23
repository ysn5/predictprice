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
import java.util.*;

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
        model.addAttribute("chartData", getChartData());
        return "contents/predictiondetail";
    }
    private List<List<Object>> getChartData() {
        List<Object> ls1=new ArrayList<>();
        ls1.add("Mushrooms");
        ls1.add(2);
        List<Object> ls2=new ArrayList<>();
        ls2.add("Onions");
        ls2.add(4);
        List<Object> ls3=new ArrayList<>();
        ls3.add("Shrimps");
        ls3.add(3);
        List<List<Object>> ls=new ArrayList<>();
        ls.add(ls1);
        ls.add(ls2);
        ls.add(ls3);

        return ls;
    }


}