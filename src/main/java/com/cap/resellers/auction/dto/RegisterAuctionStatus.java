package com.cap.resellers.auction.dto;

public enum RegisterAuctionStatus {
    FOR_SALE("판매중"),
    FAIL_BID("유찰"),
    SUCCESS_BID("낙찰")
    ;
    private String value;
    RegisterAuctionStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
