package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.strategy.CowProduceStrategy;

/**
 * Represents a Cow within the smart farm system.
 * This class specifies the attributes for a cow, including its type, the space it occupies,
 * its daily food intake, and its specific production strategy.
 */
public class Cow extends Animal {
    /**
     * Constructs a Cow with predefined attributes and a production strategy tailored for cows.
     * Defines the cow as requiring significant space and having a moderate daily food intake,
     * with a production strategy focused on typical cow products.
     */
    public Cow() {
        super("Cow", 4, 5, new CowProduceStrategy());
    }
}
