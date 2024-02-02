package com.kdu.smarthome.entities;


public enum UserRole {
    ADMIN_ROLE("Admin"),USER_ROLE("User");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

    private String role(){return role;}

}
