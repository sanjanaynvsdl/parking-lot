package models;

import java.util.UUID;
import java.time.LocalDateTime;

public class Bill {
    private UUID billId;
    private LocalDateTime exitTime;
    private double totalAmount;
    private Ticket ticket;

    public Bill() {
        
    }

    public Bill(Ticket ticket,  double totalAmout, LocalDateTime exitTime) {
        this.billId = UUID.randomUUID();
        this.ticket=ticket;
        this.totalAmount = totalAmout;
        this.exitTime = exitTime;
    }

    public UUID getBillId() {
        return billId;
    }

    public void printBill() {
        System.out.println("--------BILL----------");
        System.out.println("1. Bill ID            : " + this.billId);
        System.out.println("2. Vehicle            : "+ this.ticket.getVehicle().getVehicalNo());
        System.out.println("2. Exit Time          : " + this.exitTime);
        System.out.println("3. Parking Amount     : " + this.totalAmount);
        System.out.println("-----------------------");
    }
}
