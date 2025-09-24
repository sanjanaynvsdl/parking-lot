package src;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import src.interfaces.SlotAllocationStrategy;
import src.models.Vehicle;
import src.strategies.NearestSlotStrategy;

import java.util.ArrayList;
import java.util.List;

import enums.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("parking lot!");

        // 1. create Slots
        // 2. add to Floor
        // 3. parking Lot

        ParkingSlot slot01 = new ParkingSlot("F1S1", SlotType.SMALL);
        ParkingSlot slot02 = new ParkingSlot("F1S2", SlotType.MEDIUM);
        ParkingSlot slot03 = new ParkingSlot("F1S3", SlotType.LARGE);

        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(slot01);
        slots.add(slot02);
        slots.add(slot03);

        ParkingFloor floor1 = new ParkingFloor(1, slots);
        slot01.print();
        floor1.printSlots();

        Vehicle evCar = new Vehicle("EV123", VehicleType.CAR,FuelType.ELECTRIC, true);
        SlotAllocationStrategy baseStrategy = new NearestSlotStrategy();
        ParkingLot parkingLot = new ParkingLot()


    }
}