package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Meat;

public class PigProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building building) {
        Meat meat = new Meat("Meat", 10, 5);
        System.out.println("The pig is producing meat.");
        building.addProduct(meat);
    }
}
