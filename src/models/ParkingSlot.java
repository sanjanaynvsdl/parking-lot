package models;
import enums.*;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private Vehicle currVehicle;
    private SlotStatus slotStatus;

    public ParkingSlot(String id, SlotType slotType) {
        this.slotId = id;
        this.slotType=slotType;
        this.currVehicle=null;
        this.slotStatus=SlotStatus.EMPTY;
    }

    public void print() {
        System.out.println("slot id is : "+slotId);
    }

    public String getSlotId() {
        return this.slotId;
    } 
}
