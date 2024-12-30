package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

public class RepairedState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is repaired and turning ON.");
        equipment.setState(new OnState());
    }

    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is OFF after repairs.");
        equipment.setState(new OffState());
    }

    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already repaired.");
    }

    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is breaking down again.");
        equipment.setState(new BrokenState());
    }

    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is repaired and ready to perform actions.");
    }

    @Override
    public String toString() {
        return "RepairedState";
    }
}