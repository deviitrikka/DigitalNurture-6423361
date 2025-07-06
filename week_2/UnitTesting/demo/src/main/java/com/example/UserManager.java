package com.example;

public class UserManager {
    private NotificationService notificationService;

    public UserManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String userId) {
        // some user registration logic here
        notificationService.sendNotification(userId);
    }
}
