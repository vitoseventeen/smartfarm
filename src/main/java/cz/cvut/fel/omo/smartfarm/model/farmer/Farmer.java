package cz.cvut.fel.omo.smartfarm.model.farmer;

import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;

/**
 * Represents a Farmer in the smart farm system.
 * Farmers have states that define their current activities such as working, resting, or sleeping.
 */
public class Farmer {
    private final String name;
    private final int age;
    private FarmerState currentState;

    /**
     * Constructs a Farmer with a name, age, and an initial state.
     *
     * @param name The name of the farmer.
     * @param age The age of the farmer.
     * @param initialState The initial state of the farmer, which defines their starting activity.
     */
    public Farmer(String name, int age, FarmerState initialState) {
        this.name = name;
        this.age = age;
        this.currentState = initialState;
    }

    /**
     * Triggers the work action of the farmer according to their current state.
     */
    public void work() {
        currentState.work(this);
    }

    /**
     * Triggers the rest action of the farmer according to their current state.
     */
    public void rest() {
        currentState.rest(this);
    }

    /**
     * Triggers the sleep action of the farmer according to their current state.
     */
    public void sleep() {
        currentState.sleep(this);
    }

    /**
     * Updates the current state of the farmer to a new state.
     *
     * @param state The new state to be applied to the farmer.
     */
    public void setState(FarmerState state) {
        this.currentState = state;
    }

    /**
     * Returns the current state of the farmer.
     *
     * @return The current state of the farmer.
     */
    public FarmerState getState() {
        return currentState;
    }

    /**
     * Returns the name of the farmer.
     *
     * @return The name of the farmer.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the farmer.
     *
     * @return The age of the farmer.
     */
    public int getAge() {
        return age;
    }

    /**
     * Provides a string representation of the farmer, including name, age, and their current state.
     *
     * @return A string representation of the farmer.
     */
    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", currentState=" + currentState.getClass().getSimpleName() +
                '}';
    }
}
