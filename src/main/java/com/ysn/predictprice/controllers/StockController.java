package com.ysn.predictprice.controllers;

import com.ysn.predictprice.entities.StockPrediction;
import com.ysn.predictprice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        List<StockPrediction> predictstock = stockService.listFromLastOnes();
        model.addAttribute("predictstock", predictstock);
        List<StockPrediction> toppredictstock = stockService.topListFromLastOnes();
        model.addAttribute("toppredictstock", toppredictstock);
        return "contents/predictstock.html";
    }

    @RequestMapping(path = "/")
    public String predictstockmain(Model model){
        List<StockPrediction> predictstock = stockService.listFromLastOnes();
        model.addAttribute("predictstock", predictstock);
        List<StockPrediction> toppredictstock = stockService.topListFromLastOnes();
        model.addAttribute("toppredictstock", toppredictstock);
        return "contents/predictstock.html";
    }

    @RequestMapping(value = "/predictiondetail", method = RequestMethod.GET)
    public String predictiondetail(HttpServletRequest request, Model model) throws ParseException {
        String ticker = request.getParameter("ticker");
        model.addAttribute("ticker", ticker);
        String bd = request.getParameter("bd");
        if(bd == null) {
            bd = "30";
        }
        model.addAttribute("bd",bd);
        model.addAttribute("queryPrediction", stockService.queryPrediction(ticker));
        model.addAttribute("queryReal", stockService.queryReal(ticker));
        return "contents/predictiondetail.html";
    }
    @RequestMapping(path = "/contact")
    public String contact(Model model){
        return "contents/contact.html";
    }

    @RequestMapping(path = "/service")
    public String service(Model model){
        return "contents/service.html";
    }

    @RequestMapping(path = "/about")
    public String about(Model model){
        return "contents/about.html";
    }
}