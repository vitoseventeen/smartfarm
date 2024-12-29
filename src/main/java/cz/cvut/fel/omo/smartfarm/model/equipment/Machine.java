package cz.cvut.fel.omo.smartfarm.model.equipment;

import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;

public class Machine extends Equipment {
    private int fuelLevel;

    //TODO: IMPLEMENT MECHANISM OF FUEL CONSUMPTION
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