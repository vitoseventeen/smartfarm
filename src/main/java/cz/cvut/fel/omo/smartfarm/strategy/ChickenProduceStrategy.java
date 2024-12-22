package cz.cvut.fel.omo.smartfarm.strategy;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Egg;

public class ChickenProduceStrategy implements ProduceStrategy {

    @Override
    public void produce(Building barn) {
        Egg egg = new Egg("Egg", 3, 1);
        System.out.println("The chicken is laying eggs.");
        barn.addProduct(egg);
    }
}