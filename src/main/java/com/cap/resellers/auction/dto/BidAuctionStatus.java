package com.cap.resellers.auction.dto;

public enum BidAuctionStatus {
    BID("입찰"),
    SUCCESS_BID("낙찰"),
    FAIL_BID("패찰")
    ;
    private String value;
    BidAuctionStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
