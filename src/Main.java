package src;

import models.*;
import interfaces.*;
import strategies.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enums.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("parking lot!");

        // 1. create Slots
        // 2. add to Floor
        // 3. parking Lot

        ParkingSlot slot01 = new ParkingSlot("F1S1", SlotType.SMALL,false);
        ParkingSlot slot02 = new ParkingSlot("F1S2", SlotType.MEDIUM,true);
        ParkingSlot slot03 = new ParkingSlot("F1S3", SlotType.MEDIUM,false);
        ParkingSlot slot04 = new ParkingSlot("F1S4", SlotType.LARGE,false);

        List<ParkingSlot> slots = new ArrayList<>();
        slots.add(slot01);
        slots.add(slot02);
        slots.add(slot03);

        ParkingFloor floor1 = new ParkingFloor(1, slots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);

        EntryGate entryGate = new EntryGate("EN1");
        EntryGate entryGate2 = new EntryGate("EN2");
        ExitGate exitGate = new ExitGate("EX01");
        ExitGate exitGate2 = new ExitGate("EX02");
        
        List<EntryGate> entryGates = new ArrayList<>(Arrays.asList(entryGate, entryGate2));
        List<ExitGate> exitGates = new ArrayList<>(Arrays.asList(exitGate,exitGate2));
        
        SlotAllocationStrategy baseStrategy = new NearestSlotStrategy();
        PricingStrategy dynamicPricing = new DynamicPricing();
        PricingStrategy perHourPricing = new PerHourPricingSt();

        ParkingLot parkingLot = new ParkingLot(floors,entryGates, exitGates,baseStrategy,perHourPricing);
        
        Vehicle evCar = new Vehicle("EV123", VehicleType.CAR,FuelType.ELECTRIC);
        Vehicle bike = new Vehicle("BIKE2005", VehicleType.BIKE, FuelType.PETROL);

        Ticket evCarTicket = entryGate.generateTicket(evCar, parkingLot);
        Ticket bikeTicket = entryGate.generateTicket(bike, parkingLot);
        evCarTicket.printTicket();
        bikeTicket.printTicket();

       
        Bill evCarBill = exitGate.generateBill(evCarTicket, parkingLot.getPricingStrategy());
        Bill bikeBill = exitGate.generateBill(bikeTicket, parkingLot.getPricingStrategy());
        evCarBill.printBill();
        bikeBill.printBill();



    }
}