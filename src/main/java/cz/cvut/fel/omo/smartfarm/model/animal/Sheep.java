package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.SheepProduceStrategy;

/**
 * Represents a Sheep within the smart farm system.
 * This class details the specific attributes for a sheep, including its type, the space it occupies,
 * its daily food intake, and its specialized production strategy.
 */
public class Sheep extends Animal {
    /**
     * Constructs a Sheep with predefined attributes and a production strategy tailored for sheep.
     * The sheep is designed to require less space compared to larger animals and has a low daily food intake,
     * with a production strategy focused on wool and possibly other sheep products.
     */
    public Sheep() {
        super("Sheep", 2, 3, new SheepProduceStrategy());
    }
}
