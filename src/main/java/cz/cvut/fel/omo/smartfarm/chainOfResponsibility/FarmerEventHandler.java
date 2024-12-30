package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public class FarmerEventHandler extends EventHandler {
    private final Farmer farmer;

    public FarmerEventHandler(Farmer farmer) {
        this.farmer = farmer;
    }

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
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
