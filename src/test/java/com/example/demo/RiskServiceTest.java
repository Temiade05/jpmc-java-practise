package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RiskServiceTest {

    @Mock
    private TradeRepository tradeRepository; // The "Fake" Database

    @InjectMocks
    private RiskService riskService; // The "Real" Service we are testing

    @Test
    public void testHighRiskTrade() {
        // 1. Setup the data
        Trade badTrade = new Trade("GME", 50.0, 10);

        // 2. Run the logic
        String result = riskService.calculateRisk(badTrade);

        // 3. Verify the result
        assertEquals("RISK LEVEL: CRITICAL - Restricted Stock Detected", result);
        
        // 4. Verify the database was called ONCE
        verify(tradeRepository, times(1)).save(badTrade);
    }
}
