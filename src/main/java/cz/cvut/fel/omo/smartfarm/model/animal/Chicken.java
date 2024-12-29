package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.ChickenProduceStrategy;

public class Chicken extends Animal {
    public Chicken() {
        super("Chicken", 1, 2, new ChickenProduceStrategy());
    }
}
