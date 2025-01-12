package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.PigProduceStrategy;

/**
 * Represents a Pig within the smart farm system.
 * This class specifies the attributes for a pig, including its type, the space it occupies,
 * its daily food intake, and its specific production strategy.
 */
public class Pig extends Animal {
    /**
     * Constructs a Pig with predefined attributes and a production strategy tailored for pigs.
     * Defines the pig as requiring a moderate amount of space and having a moderate daily food intake,
     * with a production strategy focused on typical pig products.
     */
    public Pig() {
        super("Pig", 3, 4, new PigProduceStrategy());
    }
}
