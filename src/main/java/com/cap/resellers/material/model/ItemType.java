package com.cap.resellers.material.model;

public enum ItemType {
    REFRIGERATOR("냉장고/냉동고"),
    SHOW_CASE("쇼케이스"),
    FURNITURE("가구"),
    GASRANGE("가스레인지"),
    PACKING_MACHINE("포장기계"),
    WASHING_MACHINE("세척기"),
    ICE_MAKER("제빙기"),
    SINK("싱크대/작업대"),
    AIR_CONDITION("에어컨"),
    KITCHEN_GOODS("주방잡화"),
    COFFE_MACHINE("커피머신");

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
