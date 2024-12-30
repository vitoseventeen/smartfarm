package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Wool;

public class SheepProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building building) {
        Wool wool = new Wool("Wool", 4, 1);
        AppLogger.getInstance().logHint("The sheep is producing wool.");
        building.addProduct(wool);
    }
}