package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StockServiceTest {

    @Test
    public void testMultipleReturnsFromMock() {
        // Step 1: Mock the API
        StockApi mockApi = mock(StockApi.class);

        // Step 2: Stub multiple returns
        when(mockApi.getCurrentPrice())
            .thenReturn(100)
            .thenReturn(105)
            .thenReturn(110);

        // Step 3: Use in service
        StockService service = new StockService(mockApi);
        int[] prices = service.getLastThreePrices();

        // Step 4: Assert all return values
        assertArrayEquals(new int[] {100, 105, 110}, prices);
    }
}
