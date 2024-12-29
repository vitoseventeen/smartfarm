package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

public interface EquipmentState {
    void turnOn(Equipment equipment);
    void turnOff(Equipment equipment);
    void repair(Equipment equipment);
    void breakDown(Equipment equipment);
    void performAction(Equipment equipment);

}
