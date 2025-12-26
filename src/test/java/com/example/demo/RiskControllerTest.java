package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RiskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHighRiskTrade() throws Exception {
        // Create a JSON string for the trade
        String tradeJson = "{\"ticker\":\"GME\", " +
                           "\"price\": 50.0, " +
                           "\"quantity\": 100}";

        // Send a fake POST request
        mockMvc.perform(post("/api/risk/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tradeJson))
                .andExpect(status().isOk())
                .andExpect(content().string("RISK LEVEL: CRITICAL - Restricted Stock Detected"));
    }

    @Test
    public void testLowRiskTrade() throws Exception {
        String tradeJson = "{\"ticker\":\"AAPL\", \"price\": 150.0, \"quantity\": 10}";

        mockMvc.perform(post("/api/risk/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(tradeJson))
                .andExpect(status().isOk())
                .andExpect(content().string("RISK LEVEL: LOW - Trade Approved"));
    }
}
