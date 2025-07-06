package com.example;

public class DataService {
    private DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public String processData() {
        String data = repository.getData();
        return "Processed " + data;
    }
}
