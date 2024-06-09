package com.cap.resellers.auction.dto;

public enum RegisterAuctionStatus {
    FORSALE("판매중"),
    FAILBID("유찰"),
    SUCCESSBID("낙찰")
    ;
    private String value;
    RegisterAuctionStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
