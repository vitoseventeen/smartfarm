package cz.cvut.omo.model.equipment;

public abstract class Equipment {
    private String name;
    private EquipmentState currentState;

    public Equipment(String name, EquipmentState initialState) {
        this.name = name;
        this.currentState = initialState;
    }

    public String getName() {
        return name;
    }

    public EquipmentState getState() {
        return currentState;
    }

    public void setState(EquipmentState state) {
        this.currentState = state;
    }

    public void turnOn() {
        currentState.turnOn(this);
    }

    public void turnOff() {
        currentState.turnOff(this);
    }

    public void repair() {
        currentState.repair(this);
    }

    public void breakDown() {
        currentState.breakDown(this);
    }

    public void performAction() {
        currentState.performAction(this);
    }
}
