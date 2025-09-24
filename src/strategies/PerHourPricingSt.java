package strategies;

import interfaces.PricingStrategy;

public class PerHourPricingSt implements PricingStrategy {

    @Override
    public double calculatePrice() {
        return 0.2;
    }

    
    
}
