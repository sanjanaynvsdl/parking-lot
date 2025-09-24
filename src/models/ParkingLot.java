package models;
import java.util.List;
import interfaces.*;
import enums.SlotStatus;

public class ParkingLot {
    private List<ParkingFloor> parkinglot;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private SlotAllocationStrategy slotAllocatioSt;
    private PricingStrategy pricingStrategy;

    public ParkingLot() {
    }

    public ParkingLot(List<ParkingFloor> parkinglot, List<EntryGate> entryGates, List<ExitGate> exitGates,SlotAllocationStrategy slotAllocationStrategy, PricingStrategy pricingStrategy)  {
        this.parkinglot = parkinglot;
        this.entryGates=entryGates;
        this.exitGates=exitGates;
        this.slotAllocatioSt=slotAllocationStrategy;
        this.pricingStrategy=pricingStrategy;
    }

    public List<ParkingFloor> getParkinglot() {
        return parkinglot;
    }

   public ParkingSlot allocateSlot(Vehicle vehicle) {
    ParkingSlot slot = slotAllocatioSt.allocateParkingSlot(vehicle, this);

    if (slot != null) {
        // Mark the slot as occupied
        slot.setCurrVehicle(vehicle);
        slot.setSlotStatus(SlotStatus.FILLED);
    }

    return slot;
   }
}
