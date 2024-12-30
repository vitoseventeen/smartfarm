package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Milk;

public class CowProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building building) {
        Milk milk = new Milk("Milk", 5, 2);


        AppLogger.getInstance().logHint("The cow is producing milk.");

        building.addProduct(milk);
    }
}
