package cz.cvut.omo.model.equipment;

public interface EquipmentState {
    void turnOn(Equipment equipment);
    void turnOff(Equipment equipment);
    void repair(Equipment equipment);
    void breakDown(Equipment equipment);
    void performAction(Equipment equipment);
}
