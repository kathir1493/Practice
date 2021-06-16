package com.demo.jobmanagement.enums;

public enum JobPriority {
    HIGH(1), MEDIUM(2), LOW(3);

    private final int value;

    JobPriority(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
