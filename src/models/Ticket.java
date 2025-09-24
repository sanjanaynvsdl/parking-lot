package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private UUID ticketId;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private String entryGateId;
    private LocalDateTime entryTime;

    public Ticket() {
    }

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot, String entryGateId, LocalDateTime entryTime) {
        this.ticketId = UUID.randomUUID();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryGateId = entryGateId;
        this.entryTime = entryTime;
    }

    public UUID getTicketId() {
        return this.ticketId;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return this.parkingSlot;
    }

    public String getEntryGateId() {
        return this.entryGateId;
    }

    public LocalDateTime getEntryTime() {
        return this.entryTime;
    }

    public void printTicket() {
    System.out.println("--------TICKET----------");
    System.out.println("1. Ticket ID           : " + this.ticketId);
    System.out.println("2. Vehicle No.         : " + this.vehicle.getVehicalNo());
    System.out.println("3. Vehicle Type        : " + this.vehicle.getVehicleType());
    System.out.println("4. Vehicle Fuel Type   : " + this.vehicle.getFuelType());
    System.out.println("5. Slot ID             : " + this.parkingSlot.getSlotId());
    System.out.println("6. Slot Type           : " + this.parkingSlot.getSlotType());
    System.out.println("7. Slot Status         : " + this.parkingSlot.getSlotStatus());
    System.out.println("8. Charging Available? : " + this.parkingSlot.isChargingAvailable());
    System.out.println("9. Gate entry Id : "+this.getEntryGateId());
    System.out.println("10. Entry Time       : "+this.entryTime);
    System.out.println("-------------------------");
}
}
