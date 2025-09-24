package interfaces;

import models.ParkingFloor;

import models.ParkingSlot;
import models.Vehicle;
import models.ParkingLot;

import java.util.*;

public interface SlotAllocationStrategy {
    public ParkingSlot allocateParkingSlot(Vehicle vehicle, ParkingLot parkingLot);
}
