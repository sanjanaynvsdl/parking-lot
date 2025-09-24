package models;

import java.time.LocalDateTime;

import interfaces.*;

public class EntryGate {
    private String entryGateId;

    public EntryGate() {
    }

    public EntryGate(String entryGateId) {
        this.entryGateId = entryGateId;
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingLot parkingLot) {
        ParkingSlot slot = parkingLot.allocateSlot(vehicle);

        if (slot == null) {
            throw new RuntimeException("No available parkingslots");
        }

        return new Ticket(vehicle, slot, this.entryGateId, LocalDateTime.now());
    }


}
