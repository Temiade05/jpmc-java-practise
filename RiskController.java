package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/risk") // This is your "Website" URL
public class RiskController {

    // A simple endpoint to check if the server is awake
    @GetMapping("/status")
    public String getStatus() {
        return "Risk Engine is Online and Running";
    }

    // A simulated database of "High Risk" stocks
    private List<String> highRiskStocks = List.of("GME", "AMC", "CRYPTO");

    // The Logic: Calculate Risk
    @PostMapping("/calculate")
    public String calculateRisk(@RequestBody Trade trade) {
        // Business Logic
        double totalValue = trade.getPrice() * trade.getQuantity();

        if (highRiskStocks.contains(trade.getTicker())) {
            return "RISK LEVEL: CRITICAL - Restricted Stock Detected";
        } else if (totalValue > 1000000) {
            return "RISK LEVEL: HIGH - Trade value too large";
        } else {
            return "RISK LEVEL: LOW - Trade Approved";
        }
    }
}