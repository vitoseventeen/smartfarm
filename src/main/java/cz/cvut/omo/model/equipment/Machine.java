package cz.cvut.omo.model.equipment;

public class Machine extends Equipment {
    private int fuelLevel; // Уровень топлива


    public Machine(String name, EquipmentStatus status, int fuelLevel) {
        super(name, status);
        this.fuelLevel = fuelLevel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void performAction() {
        System.out.println("Машина " + getName() + " выполняет задачу.");
    }
}