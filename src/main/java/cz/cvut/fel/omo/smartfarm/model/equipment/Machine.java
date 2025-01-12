package cz.cvut.fel.omo.smartfarm.model.equipment;

import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;

/**
 * Represents a Machine within the smart farm system.
 * Machines are specialized types of equipment that additionally manage fuel levels for operations.
 */
public class Machine extends Equipment {
    private int fuelLevel;

    /**
     * Constructs a Machine with a specified name and initial fuel level.
     * Initializes the machine in an off state.
     *
     * @param name The name of the machine, used for identification.
     * @param fuelLevel The initial fuel level of the machine.
     */
    public Machine(String name, int fuelLevel) {
        super(name, new OffState());
        this.fuelLevel = fuelLevel;
    }

    /**
     * Returns the current fuel level of the machine.
     *
     * @return The current fuel level.
     */
    public int getFuelLevel() {
        return fuelLevel;
    }

    /**
     * Sets the fuel level of the machine.
     *
     * @param fuelLevel The new fuel level for the machine.
     */
    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
