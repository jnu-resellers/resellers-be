package com.cap.resellers.auction.model;

public enum UserRole {
    SELLER("판매자"),
    BUYER("구매자")
    ;

    private String value;
    UserRole(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
