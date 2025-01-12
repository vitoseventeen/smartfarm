package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Wool;

/**
 * This class implements the ProduceStrategy interface to define the wool production process for sheep.
 */
public class SheepProduceStrategy implements ProduceStrategy {

    /**
     * The produce method simulates the wool production process in a sheep building.
     * It creates a new Wool object and adds it to the building's product list.
     *
     * @param building The building where the wool is produced.
     */
    @Override
    public void produce(Building building) {
        // Create a new Wool object with the specified name, weight, and value
        Wool wool = new Wool("Wool", 4, 1);

        // Log a hint message that the sheep is producing wool
        AppLogger.getInstance().logHint("The sheep is producing wool.");

        // Add the produced wool to the building's product list
        building.addProduct(wool);
    }
}
