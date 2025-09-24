package strategies;

import interfaces.PricingStrategy;
import models.Ticket;

public class DynamicPricing implements PricingStrategy {
    
    @Override
    public double calculatePrice(Ticket ticket) {
        return 200.20;
    }
    
}
