package models;
import interfaces.*;

public class EntryGate {
    private String entryGateId;
    private SlotAllocationStrategy slotAllocationSt;

    public EntryGate() {
    }

    public EntryGate(String entryGateId, SlotAllocationStrategy slotAllocationSt) {
        this.entryGateId = entryGateId;
        this.slotAllocationSt = slotAllocationSt;
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public SlotAllocationStrategy getSlotAllocationSt() {
        return slotAllocationSt;
    }
}
