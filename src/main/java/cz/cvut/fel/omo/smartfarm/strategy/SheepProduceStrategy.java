package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Wool;

public class SheepProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building barn) {
        Wool wool = new Wool("Wool", 4, 1);
        System.out.println("The sheep is producing wool.");
        barn.addProduct(wool);
    }
}