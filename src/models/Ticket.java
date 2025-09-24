package models;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private  UUID ticketId;
    private  Vehicle vehicle;
    private  ParkingSlot parkingSlot;
    private  String entryGateId;
    private  LocalDateTime entryTime;

    public Ticket() {
    }

    public Ticket(UUID ticketId, Vehicle vehicle, ParkingSlot parkingSlot, String entryGateId, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryGateId = entryGateId;
        this.entryTime = entryTime;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void print() {
        // System.out.println(ticketId , vehicle  , entryGateId , entryTime);
    }
}
