package com.traffic;

public class Vehicle {

    private String number;
    private String owner;
    private String type;
    private int violationCount;

    public Vehicle(String number, String owner, String type) {

        this.number = number;
        this.owner = owner;
        this.type = type;
        this.violationCount = 0;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public int getViolationCount() {
        return violationCount;
    }

    public void addViolation() {
        violationCount++;
    }

    public String getClassification() {

        if (violationCount >= 3)
            return "HIGH RISK";

        if (violationCount == 2)
            return "MEDIUM RISK";

        return "LOW RISK";
    }
}
