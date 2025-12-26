package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

    @GetMapping("/status")
    public String getStatus() {
        return "Risk Engine is Online and Running";
    }

    private List<String> highRiskStocks = List.of("GME", "AMC", "CRYPTO");

    @PostMapping("/calculate")
    public String calculateRisk(@RequestBody Trade trade) {
        double totalValue = trade.getPrice() * trade.getQuantity();

        if (highRiskStocks.contains(trade.getTicker())) {
            return "RISK LEVEL: CRITICAL - Restricted Stock Detected";
        } else if (totalValue > 1000000) {
            return "RISK LEVEL: HIGH - Trade value too large";
        } else if(trade.getTicker().equals("TSLA")){
            return "RISK LEVEL: MEDIUM - Volatile Stock";
        }else {
            return "RISK LEVEL: LOW - Trade Approved";
        }
        
    }
}
