package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Egg;

/**
 * This class implements the ProduceStrategy interface to define the egg production process for chickens.
 */
public class ChickenProduceStrategy implements ProduceStrategy {

    /**
     * The produce method simulates the egg production process in a chicken building.
     * It creates a new Egg object and adds it to the building's product list.
     *
     * @param building The building where the egg is produced.
     */
    @Override
    public void produce(Building building) {
        // Create a new Egg object with the specified name, weight, and value
        Egg egg = new Egg("Egg", 3, 1);

        // Log a hint message that the chicken is laying eggs
        AppLogger.getInstance().logHint("The chicken is laying eggs.");

        // Add the produced egg to the building's product list
        building.addProduct(egg);
    }
}
