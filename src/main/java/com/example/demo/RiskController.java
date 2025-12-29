package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

@RestController
@RequestMapping("/api/risk")
public class RiskController {
    private final RiskService riskService;

    public RiskController(RiskService riskService) {
        this.riskService = riskService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return "Risk Engine is Online and Running";
    }


    @PostMapping("/calculate")
    public String calculateRisk(@RequestBody Trade trade) {
        return riskService.calculateRisk(trade);
    }
}
