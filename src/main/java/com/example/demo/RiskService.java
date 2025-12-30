package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Service
public class RiskService {

    private final TradeRepository tradeRepository;
    private final Set<String> highRiskStocks = new HashSet<>(Arrays.asList("GME", "AMC", "CRYPTO"));

    // Inject the Repository
    public RiskService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public String calculateRisk(Trade trade) {
        // 1. Save the trade to the database!
        tradeRepository.save(trade);

        // 2. Perform the logic
        double totalValue = trade.getPrice() * trade.getQuantity();

        if (highRiskStocks.contains(trade.getTicker())) {
            return "RISK LEVEL: CRITICAL - Restricted Stock Detected";
        } else if (totalValue > 1000000) {
            return "RISK LEVEL: HIGH - Trade value too large";
        } else if (trade.getTicker().equals("TSLA")) {
            return "RISK LEVEL: MEDIUM - Volatile Stock";
        } else {
            return "RISK LEVEL: LOW - Trade Approved";
        }
    }
}
