package models;
import interfaces.*;

public class ExitGate {
    private String exitGateId;
    private PricingStrategy pricingStrategy;

    public ExitGate() {
    }

    public ExitGate(String exitGateId, PricingStrategy pricingStrategy) {
        this.exitGateId = exitGateId;
        this.pricingStrategy = pricingStrategy;
    }

    public String getExitGateId() {
        return exitGateId;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
