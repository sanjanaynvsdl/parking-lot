package models;
import enums.*;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private Vehicle currVehicle;
    private SlotStatus slotStatus;

    public ParkingSlot() {
    }

    public ParkingSlot(String id, SlotType slotType) {
        this.slotId = id;
        this.slotType=slotType;
        this.currVehicle=null;
        this.slotStatus=SlotStatus.EMPTY;
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

    public void print() {
        System.out.println("slot id is : "+slotId);
    }
}
