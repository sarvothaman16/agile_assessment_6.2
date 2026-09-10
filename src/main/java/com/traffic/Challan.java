package com.traffic;

import java.time.LocalDateTime;

public class Challan {

    private String challanId;
    private String vehicleNumber;
    private ViolationType violation;
    private String location;
    private double speed;
    private double permittedSpeed;
    private double fine;
    private PaymentStatus paymentStatus;
    private LocalDateTime timestamp;

    public Challan(String challanId,
                   String vehicleNumber,
                   ViolationType violation,
                   String location,
                   double speed,
                   double permittedSpeed,
                   double fine) {

        this.challanId = challanId;
        this.vehicleNumber = vehicleNumber;
        this.violation = violation;
        this.location = location;
        this.speed = speed;
        this.permittedSpeed = permittedSpeed;
        this.fine = fine;
        this.paymentStatus = PaymentStatus.UNPAID;
        this.timestamp = LocalDateTime.now();
    }

    public String getChallanId() {
        return challanId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getFine() {
        return fine;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void pay() {
        paymentStatus = PaymentStatus.PAID;
    }

    @Override
    public String toString() {

        return "Challan ID: " + challanId
            + " | Vehicle: " + vehicleNumber
            + " | Violation: " + violation
            + " | Fine: ₹" + fine
            + " | Status: " + paymentStatus;
    }
}
