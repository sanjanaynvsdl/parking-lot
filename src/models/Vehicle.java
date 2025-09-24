package models;

import enums.FuelType;
import enums.VehicleType;

public class Vehicle {
    private  String vehicalNo;
    private  VehicleType vehicleType;
    private FuelType fuelType;

    public Vehicle() {
    }

    public Vehicle(String vehicalNo, VehicleType vehicleType, FuelType fuelType) {
        this.vehicalNo = vehicalNo;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }

    public String getVehicalNo() {
        return vehicalNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
