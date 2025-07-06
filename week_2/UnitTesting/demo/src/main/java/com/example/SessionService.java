package com.example;

public class SessionService {
    private SessionManager sessionManager;

    public SessionService(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void performSession(String userId) {
        sessionManager.login(userId);
        sessionManager.fetchData();
        sessionManager.logout();
    }
}
