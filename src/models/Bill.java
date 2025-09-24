package models;

import java.util.UUID;

public class Bill {
    private UUID billId;
    private Vehicle vehicle;
    private double totalAmout;

    public Bill() {
    }

    public Bill(UUID billId, Vehicle vehicle, double totalAmout) {
        this.billId = billId;
        this.vehicle = vehicle;
        this.totalAmout = totalAmout;
    }

    public UUID getBillId() {
        return billId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getTotalAmout() {
        return totalAmout;
    }
}
