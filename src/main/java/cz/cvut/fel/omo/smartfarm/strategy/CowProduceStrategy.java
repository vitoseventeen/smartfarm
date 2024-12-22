package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Milk;

public class CowProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building barn) {
        Milk milk = new Milk("Milk", 5, 2);
        System.out.println("The cow is producing milk.");
        barn.addProduct(milk);
    }
}
