package com.example;

public class UserService {
    private UserApi userApi;

    public UserService(UserApi userApi) {
        this.userApi = userApi;
    }

    public void performUpdate() {
        userApi.updateUser("user42", 30);  // This is what we want to verify
    }
}
