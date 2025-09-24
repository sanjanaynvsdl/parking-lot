package strategies;

import java.time.LocalDateTime;
import java.time.Duration;

import interfaces.PricingStrategy;
import models.Ticket;

public class PerHourPricingSt implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        // return 0.2;
        System.out.println("clautationt he price!");

        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime currTime = LocalDateTime.now();
        long hours = Duration.between(entryTime, currTime).toHours();

        return hours + 100;

    }

}
