package com.example;

public class StockService {
    private StockApi stockApi;

    public StockService(StockApi stockApi) {
        this.stockApi = stockApi;
    }

    public int[] getLastThreePrices() {
        return new int[] {
            stockApi.getCurrentPrice(),
            stockApi.getCurrentPrice(),
            stockApi.getCurrentPrice()
        };
    }
}
