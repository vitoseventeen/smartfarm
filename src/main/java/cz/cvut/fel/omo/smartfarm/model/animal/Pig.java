package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.PigProduceStrategy;

public class Pig extends Animal {
    public Pig() {
        super("Pig", 3, 4, new PigProduceStrategy());
    }
}
