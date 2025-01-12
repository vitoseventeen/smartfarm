package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

/**
 * Handles events related to the farmer within the smart farm system.
 * This handler responds to farmer-specific events such as working, resting, and sleeping.
 * If an event cannot be handled, it is passed to the next handler in the chain of responsibility.
 */
public class FarmerEventHandler extends EventHandler {
    private final Farmer farmer;

    /**
     * Constructs a FarmerEventHandler with a specific farmer.
     *
     * @param farmer The farmer who will be affected by the events.
     */
    public FarmerEventHandler(Farmer farmer) {
        this.farmer = farmer;
    }

    /**
     * Handles farmer-related events by invoking actions on the farmer instance based on the event type.
     * If the event is not related to the farmer, it is passed along to the next handler in the chain.
     *
     * @param event The event to be handled, expected to be one of the farmer-related types.
     */
    @Override
    public void handleEvent(Event event) {
        switch (event.getType()) {
            case FARMER_WORK:
                farmer.work();
                break;

            case FARMER_REST:
                farmer.rest();
                break;

            case FARMER_SLEEP:
                farmer.sleep();
                break;

            default:
                // Pass the event to the next handler in the chain if this one can't process it
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
