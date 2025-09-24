package models;

import java.util.UUID;
import java.time.LocalDateTime;

public class Bill {
    private UUID billId;
    private Ticket ticket;
    private LocalDateTime exitTime;
    private double totalAmount;
    private double chargingCost;

    public Bill() {
    }

    public Bill(Vehicle vehicle, double totalAmout,ExitGate exitGate) {
        this.billId =UUID.randomUUID() ;
        this.vehicle = vehicle;
        this.totalAmout = totalAmout;
        this.exitGate=exitGate;
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
