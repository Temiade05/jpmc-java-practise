package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class RiskService {
    private Set<String> highRiskStocks = new HashSet<>(Arrays.asList("GME", "AMC", "CRYPTO"));

    public String assessRisk(Trade trade) {
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