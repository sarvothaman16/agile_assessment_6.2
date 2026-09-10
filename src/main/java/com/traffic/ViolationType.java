package com.traffic;

public enum ViolationType {

    OVER_SPEEDING(1000),
    SIGNAL_VIOLATION(1500),
    ILLEGAL_PARKING(500);

    private final double fine;

    ViolationType(double fine) {
        this.fine = fine;
    }

    public double getFine() {
        return fine;
    }
}
