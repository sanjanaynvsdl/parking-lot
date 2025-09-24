package src.models;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private  UUID ticketId;
    private  Vehicle vehicle;
    private  ParkingSlot parkingSlot;
    private  String entryGateId;
    private  LocalDateTime entryTime;

    public void print() {
        // System.out.println(ticketId , vehicle  , entryGateId , entryTime);
    }



    
}
