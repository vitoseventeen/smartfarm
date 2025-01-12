package cz.cvut.fel.omo.smartfarm.model.equipment;

import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;

/**
 * Abstract base class for various types of equipment within the smart farm system.
 * Manages the state of equipment and defines common operations such as turning on and off, repairing, and handling breakdowns.
 */
public abstract class Equipment {
    private final String name;
    private EquipmentState currentState;

    /**
     * Constructs Equipment with a name and initial state.
     *
     * @param name The name of the equipment.
     * @param initialState The initial state of the equipment, determining its initial behavior and status.
     */
    public Equipment(String name, EquipmentState initialState) {
        this.name = name;
        this.currentState = initialState;
    }

    /**
     * Returns the name of the equipment.
     *
     * @return The name of the equipment.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current state of the equipment.
     *
     * @return The current state of the equipment.
     */
    public EquipmentState getState() {
        return currentState;
    }

    /**
     * Sets the state of the equipment to a new state.
     *
     * @param state The new state for the equipment.
     */
    public void setState(EquipmentState state) {
        this.currentState = state;
    }

    /**
     * Instructs the equipment to turn on. The behavior depends on the current state.
     */
    public void turnOn() {
        currentState.turnOn(this);
    }

    /**
     * Instructs the equipment to turn off. The behavior depends on the current state.
     */
    public void turnOff() {
        currentState.turnOff(this);
    }

    /**
     * Instructs the equipment to undergo repairs. The behavior depends on the current state.
     */
    public void repair() {
        currentState.repair(this);
    }

    /**
     * Simulates a breakdown of the equipment, transitioning its state accordingly.
     */
    public void breakDown() {
        currentState.breakDown(this);
    }

    /**
     * Instructs the equipment to perform its designated action, which varies based on the current state.
     */
    public void performAction() {
        currentState.performAction(this);
    }

    /**
     * Returns a string representation of the equipment, including its name and current state.
     *
     * @return A string description of the equipment.
     */
    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", currentState=" + currentState +
                '}';
    }
}
