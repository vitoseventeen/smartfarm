package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Milk;

/**
 * This class implements the ProduceStrategy interface to define the milk production process for cows.
 */
public class CowProduceStrategy implements ProduceStrategy {

    /**
     * The produce method simulates the milk production process in a cow building.
     * It creates a new Milk object and adds it to the building's product list.
     *
     * @param building The building where the milk is produced.
     */
    @Override
    public void produce(Building building) {
        // Create a new Milk object with the specified name, weight, and value
        Milk milk = new Milk("Milk", 5, 2);

        // Log a hint message that the cow is producing milk
        AppLogger.getInstance().logHint("The cow is producing milk.");

        // Add the produced milk to the building's product list
        building.addProduct(milk);
    }
}
