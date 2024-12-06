package cz.cvut.omo.state.equipment;

import cz.cvut.omo.model.equipment.Equipment;

public interface EquipmentState {
    void turnOn(Equipment equipment);
    void turnOff(Equipment equipment);
    void repair(Equipment equipment);
    void breakDown(Equipment equipment);
    void performAction(Equipment equipment);

}
