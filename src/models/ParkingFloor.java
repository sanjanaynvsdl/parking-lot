package models;

import java.util.List;

public class ParkingFloor {
    private int floorId;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorId, List<ParkingSlot> slots) {
        this.floorId=floorId;
        this.parkingSlots=slots;
    }

    public void printSlots() {
        for(ParkingSlot  eachSlot: parkingSlots) {
            System.out.println(eachSlot.getSlotId());
        }
    }    
}
