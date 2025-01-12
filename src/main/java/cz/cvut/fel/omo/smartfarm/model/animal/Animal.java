package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.strategy.ProduceStrategy;

/**
 * Abstract class representing a general animal in the smart farm system.
 * This class encapsulates common attributes and functionalities for all animals such as type,
 * space occupancy, daily food intake, and production strategy.
 */
public abstract class Animal {
    private String type;
    private final int takesPlaces;
    private final int dailyFoodIntake;
    private ProduceStrategy produceStrategy;

    /**
     * Constructs an animal with specified characteristics and production strategy.
     *
     * @param type The type of the animal, e.g., "Cow", "Chicken".
     * @param takesPlaces The amount of space the animal occupies.
     * @param dailyFoodIntake The daily amount of food the animal consumes.
     * @param produceStrategy The strategy defining how the animal produces goods.
     */
    public Animal(String type, int takesPlaces, int dailyFoodIntake, ProduceStrategy produceStrategy) {
        this.type = type;
        this.takesPlaces = takesPlaces;
        this.dailyFoodIntake = dailyFoodIntake;
        this.produceStrategy = produceStrategy;
    }

    /**
     * Gets the type of the animal.
     *
     * @return The type of the animal.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the amount of space the animal occupies.
     *
     * @return The space occupancy of the animal.
     */
    public int getTakesPlaces() {
        return takesPlaces;
    }

    /**
     * Gets the daily food intake of the animal.
     *
     * @return The daily food consumption of the animal.
     */
    public int getDailyFoodIntake() {
        return dailyFoodIntake;
    }

    /**
     * Sets the production strategy of the animal.
     *
     * @param produceStrategy The new production strategy for the animal.
     */
    public void setProduceStrategy(ProduceStrategy produceStrategy) {
        this.produceStrategy = produceStrategy;
    }

    /**
     * Executes the production process for the animal using its current strategy.
     *
     * @param barn The building where the production takes place.
     */
    public void produce(Building barn) {
        produceStrategy.produce(barn);
    }

    /**
     * Provides a string representation of the animal including its type, space occupancy, and daily food intake.
     *
     * @return A string description of the animal.
     */
    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", takesPlaces=" + takesPlaces +
                ", dailyFoodIntake=" + dailyFoodIntake +
                '}';
    }

    /**
     * Sets the type of the animal.
     *
     * @param type The new type of the animal.
     */
    public void setType(String type) {
        this.type = type;
    }
}
