package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Meat;

/**
 * This class implements the ProduceStrategy interface to define the meat production process for pigs.
 */
public class PigProduceStrategy implements ProduceStrategy {

    /**
     * The produce method simulates the meat production process in a pig building.
     * It creates a new Meat object and adds it to the building's product list.
     *
     * @param building The building where the meat is produced.
     */
    @Override
    public void produce(Building building) {
        // Create a new Meat object with the specified name, weight, and value
        Meat meat = new Meat("Meat", 10, 5);

        // Log a hint message that the pig is producing meat
        AppLogger.getInstance().logHint("The pig is producing meat.");

        // Add the produced meat to the building's product list
        building.addProduct(meat);
    }
}
