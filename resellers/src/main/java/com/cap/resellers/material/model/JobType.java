package com.cap.resellers.material.model;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

public enum JobType {
    FOOD("요식업");

    private String value;

    JobType(String value) {
        this.value = value;
    }
}
