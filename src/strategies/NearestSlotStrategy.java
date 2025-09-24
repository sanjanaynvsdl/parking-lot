package strategies;

import interfaces.SlotAllocationStrategy;
import enums.FuelType;
import enums.SlotStatus;
import enums.SlotType;
import enums.VehicleType;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import models.Vehicle;

public class NearestSlotStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSlot allocateParkingSlot(Vehicle vehicle, ParkingLot parkingLot) {
        boolean needsCharging = vehicle.getFuelType() == FuelType.ELECTRIC;
        System.out.println("allocation the slot!");

        for (ParkingFloor floor : parkingLot.getFloors()) {
            for (ParkingSlot slot : floor.getParkingSlots()) {

                // Check if slot is available
                if (slot.getSlotStatus() != SlotStatus.EMPTY) {
                    continue;
                }

                // Check if vehicle fits in slot type
                if (!isVehicleCompatible(vehicle, slot)) {
                    continue;
                }

                // For EV vehicles, MUST have charging point
                if (needsCharging) {
                    if (slot.isChargingAvailable()) {
                        return slot; // Found EV slot
                    }
                    // Continue looking for charging slots
                } else {
                    // Non-EV can use any compatible slot
                    return slot;
                }
            }
        }

        return null; // No suitable slot found
    }

    private boolean isVehicleCompatible(Vehicle vehicle, ParkingSlot slot) {
        VehicleType vehicleType = vehicle.getVehicleType();
        SlotType slotType = slot.getSlotType();

        switch (vehicleType) {
            case BIKE:
                // Bike can fit in any slot size
                return slotType == SlotType.SMALL || slotType == SlotType.MEDIUM || slotType == SlotType.LARGE;

            case AUTO:
            case CAR:
                // Car/Auto needs medium or large
                return slotType == SlotType.MEDIUM || slotType == SlotType.LARGE;

            case BUS:
                // Bus needs large slot only
                return slotType == SlotType.LARGE;

            default:
                return false;
        }
    }
}
