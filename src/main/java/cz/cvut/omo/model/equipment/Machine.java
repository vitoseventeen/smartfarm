package cz.cvut.omo.model.equipment;

import cz.cvut.omo.state.equipment.OffState;

public class Machine extends Equipment {
    private int fuelLevel;

    public Machine(String name, int fuelLevel) {
        super(name, new OffState());
        this.fuelLevel = fuelLevel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}