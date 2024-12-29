package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public class FarmerEventHandler extends EventHandler {
    private final Farmer farmer;

    // Конструктор для инициализации фермера
    public FarmerEventHandler(Farmer farmer) {
        this.farmer = farmer;
    }

    @Override
    public void handleEvent(Event event) {
        switch (event.getType()) {
            case FARMER_WORK:
                farmer.work();
                System.out.println(farmer.getName() + " is now working.");
                break;

            case FARMER_REST:
                farmer.rest();
                System.out.println(farmer.getName() + " is now resting.");
                break;

            case FARMER_SLEEP:
                farmer.sleep();
                System.out.println(farmer.getName() + " is now sleeping.");
                break;

            default:
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
