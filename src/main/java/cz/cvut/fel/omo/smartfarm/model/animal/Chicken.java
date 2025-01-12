package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.ChickenProduceStrategy;

/**
 * Represents a Chicken in the smart farm system.
 * This class defines the specific attributes for a chicken, including its type, space required,
 * daily food intake, and production strategy.
 */
public class Chicken extends Animal {
    /**
     * Constructs a Chicken with predefined attributes and a specific production strategy.
     * The chicken occupies minimal space and has a low daily food intake, with a production
     * strategy that is specialized for chickens.
     */
    public Chicken() {
        super("Chicken", 1, 2, new ChickenProduceStrategy());
    }
}
