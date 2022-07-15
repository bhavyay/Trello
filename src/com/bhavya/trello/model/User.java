package com.bhavya.trello.model;

public class User extends BaseModel {
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String userId;
    private String name;
    private String email;

    public User(String name, String email) {
        this.userId = generateId();
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
