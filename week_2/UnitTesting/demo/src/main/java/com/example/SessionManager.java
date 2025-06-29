package com.example;

public interface SessionManager {
    void login(String userId);
    void fetchData();
    void logout();
}
