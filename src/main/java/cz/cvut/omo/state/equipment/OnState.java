package cz.cvut.omo.state.equipment;

import cz.cvut.omo.model.equipment.Equipment;

public class OnState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        System.out.println(equipment.getName() + " is already ON.");
    }

    @Override
    public void turnOff(Equipment equipment) {
        System.out.println(equipment.getName() + " is turning OFF.");
        equipment.setState(new OffState());
    }

    @Override
    public void repair(Equipment equipment) {
        System.out.println(equipment.getName() + " is ON and doesn't need repairs.");
    }

    @Override
    public void breakDown(Equipment equipment) {
        System.out.println(equipment.getName() + " is breaking down.");
        equipment.setState(new BrokenState());
    }

    @Override
    public void performAction(Equipment equipment) {
        System.out.println(equipment.getName() + " is performing its action.");
    }

    @Override
    public String toString() {
        return "OnState";
    }
}