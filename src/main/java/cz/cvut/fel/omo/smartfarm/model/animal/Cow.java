package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.products.Milk;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.strategy.CowProduceStrategy;

public class Cow extends Animal {
    public Cow() {
        super("Cow", 4, 5, new CowProduceStrategy());
    }
}
