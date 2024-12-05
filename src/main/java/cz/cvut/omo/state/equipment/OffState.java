package cz.cvut.omo.state.equipment;

import cz.cvut.omo.model.equipment.Equipment;

public class OffState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        System.out.println(equipment.getName() + " is turning ON.");
        equipment.setState(new OnState());
    }

    @Override
    public void turnOff(Equipment equipment) {
        System.out.println(equipment.getName() + " is already OFF.");
    }

    @Override
    public void repair(Equipment equipment) {
        System.out.println(equipment.getName() + " is OFF and doesn't need repairs.");
    }

    @Override
    public void breakDown(Equipment equipment) {
        System.out.println(equipment.getName() + " is breaking down while OFF.");
        equipment.setState(new BrokenState());
    }

    @Override
    public void performAction(Equipment equipment) {
        System.out.println(equipment.getName() + " is OFF and cannot perform any actions.");
    }
}