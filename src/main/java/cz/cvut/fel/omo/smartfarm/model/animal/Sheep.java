package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.SheepProduceStrategy;

public class Sheep extends Animal {
    public Sheep() {
        super("Sheep", 2, 3, new SheepProduceStrategy());
    }
}
