package com.traffic;

import java.util.*;
import com.traffic.exceptions.InvalidVehicleException;

public class TrafficManager {

    private Map<String, Vehicle> vehicles = new HashMap<>();
    private List<Challan> challans = new ArrayList<>();

    public void registerVehicle(Vehicle vehicle)
            throws InvalidVehicleException {

        if (vehicle.getNumber() == null ||
            vehicle.getNumber().isEmpty()) {

            throw new InvalidVehicleException(
                "Invalid vehicle number"
            );
        }

        if (vehicles.containsKey(vehicle.getNumber())) {

            throw new InvalidVehicleException(
                "Vehicle already registered"
            );
        }

        vehicles.put(vehicle.getNumber(), vehicle);

        System.out.println(
            "Vehicle registered: "
            + vehicle.getNumber()
        );
    }

    public void createChallan(
            String vehicleNumber,
            ViolationType violation,
            String location,
            double speed,
            double permittedSpeed)
            throws InvalidVehicleException {

        Vehicle vehicle = vehicles.get(vehicleNumber);

        if (vehicle == null) {
            throw new InvalidVehicleException(
                "Vehicle not registered"
            );
        }

        if (violation == null) {
            throw new InvalidVehicleException(
                "Invalid violation type"
            );
        }

        if (location == null || location.isEmpty()) {
            throw new InvalidVehicleException(
                "Invalid location"
            );
        }

        vehicle.addViolation();

        double fine = violation.getFine();

        if (vehicle.getViolationCount() > 1) {
            fine = fine * 1.5;
        }

        String id = "CH" + (challans.size() + 1);

        Challan challan = new Challan(
            id,
            vehicleNumber,
            violation,
            location,
            speed,
            permittedSpeed,
            fine
        );

        challans.add(challan);

        System.out.println("\nE-Challan Generated:");
        System.out.println(challan);
    }

    public void payChallan(String id) {

        for (Challan c : challans) {

            if (c.getChallanId().equals(id)) {

                c.pay();

                System.out.println(
                    "Challan " + id +
                    " paid successfully."
                );

                return;
            }
        }

        System.out.println("Challan not found.");
    }

    public double getOutstandingFine(String vehicleNumber) {

        double total = 0;

        for (Challan c : challans) {

            if (c.getVehicleNumber().equals(vehicleNumber)
                    && c.getPaymentStatus()
                       == PaymentStatus.UNPAID) {

                total += c.getFine();
            }
        }

        return total;
    }

    public void displayVehicleClassification(
            String vehicleNumber) {

        Vehicle v = vehicles.get(vehicleNumber);

        if (v != null) {

            System.out.println(
                "Vehicle: " + vehicleNumber
                + " | Classification: "
                + v.getClassification()
            );
        }
    }

    public void displayChallans() {

        for (Challan c : challans) {
            System.out.println(c);
        }
    }
}
