package com.traffic;

public class Main {

    public static void main(String[] args) {

        TrafficManager manager = new TrafficManager();

        try {

            manager.registerVehicle(
                new Vehicle(
                    "TN01AB1234",
                    "Arun Kumar",
                    "Car"
                )
            );

            manager.registerVehicle(
                new Vehicle(
                    "TN02CD5678",
                    "Rahul",
                    "Bike"
                )
            );

            manager.createChallan(
                "TN01AB1234",
                ViolationType.OVER_SPEEDING,
                "Vellore",
                90,
                60
            );

            manager.createChallan(
                "TN01AB1234",
                ViolationType.SIGNAL_VIOLATION,
                "Katpadi",
                0,
                0
            );

            manager.createChallan(
                "TN02CD5678",
                ViolationType.ILLEGAL_PARKING,
                "Sathuvachari",
                0,
                0
            );

            System.out.println(
                "\nOutstanding Fine: ₹"
                + manager.getOutstandingFine(
                    "TN01AB1234"
                )
            );

            manager.payChallan("CH1");

            System.out.println(
                "\nOutstanding Fine after payment: ₹"
                + manager.getOutstandingFine(
                    "TN01AB1234"
                )
            );

            manager.displayVehicleClassification(
                "TN01AB1234"
            );

            System.out.println("\nAll Challans:");

            manager.displayChallans();

        } catch (Exception e) {

            System.out.println(
                "ERROR: " + e.getMessage()
            );
        }
    }
}
