package models;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkinglot;

    public ParkingLot() {
    }

    public ParkingLot(List<ParkingFloor> parkinglot) {
        this.parkinglot = parkinglot;
    }

    public List<ParkingFloor> getParkinglot() {
        return parkinglot;
    }
}
