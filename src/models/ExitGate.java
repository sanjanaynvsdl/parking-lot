package models;
import interfaces.*;
import enums.FuelType;
import enums.SlotStatus;
import java.time.LocalDateTime;

public class ExitGate {
    private String exitGateId;


    public ExitGate() {
    }

    public ExitGate(String exitGateId) {
        this.exitGateId = exitGateId;
    }

    public String getExitGateId() {
        return exitGateId;
    }

    public Bill generateBill(Ticket ticket, PricingStrategy pricingStrategy) {
        LocalDateTime exitTime = LocalDateTime.now();
        ParkingSlot slot = ticket.getParkingSlot();

        // Calculate base parking cost
        double baseCost = pricingStrategy.calculatePrice(ticket);

        // Add charging cost if EV used charging slot
        double chargingCost = 0;
        Vehicle vehicle = ticket.getVehicle();
        if (vehicle.getFuelType() == FuelType.ELECTRIC && slot.isChargingAvailable()) {
            chargingCost = 50.0; // Fixed charging fee
        }

        double totalAmount = baseCost + chargingCost;

        // Free the slot
        slot.setCurrVehicle(null);
        slot.setSlotStatus(SlotStatus.EMPTY);

        return new Bill(ticket, totalAmount, exitTime);
    }
}
