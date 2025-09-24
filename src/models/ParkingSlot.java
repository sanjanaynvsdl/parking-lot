package models;

import enums.*;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private Vehicle currVehicle;
    private SlotStatus slotStatus;
    private boolean isChargingAvailable;

    public ParkingSlot() {

    }

    public ParkingSlot(String id, SlotType slotType, boolean isCharging) {
        this.slotId = id;
        this.slotType = slotType;
        this.currVehicle = null;
        this.slotStatus = SlotStatus.EMPTY;
        this.isChargingAvailable = isCharging;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public Vehicle getCurrVehicle() {
        return currVehicle;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public boolean isChargingAvailable() {
        return isChargingAvailable;
    }

    public void setCurrVehicle(Vehicle vehicle) {
        this.currVehicle = vehicle;
    }

    public void setSlotStatus(SlotStatus status) {
        this.slotStatus = status;
    }

    public void print() {
        System.out.println("slot id is : " + slotId);
    }
}
