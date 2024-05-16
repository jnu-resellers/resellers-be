package com.cap.resellers.material.model;

public enum ItemType {
    REFRIGERATOR("냉장고"),
    CHOPSTICKS("젓가락"),
    BOWL("그릇"),
    ICE_MAKER("제빙기"),
    SINK("싱크대"),
    OVEN("오븐");

    private String value;

    public static ItemType fromValue(String value) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getValue().equals(value)) {
                return itemType;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

    ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
