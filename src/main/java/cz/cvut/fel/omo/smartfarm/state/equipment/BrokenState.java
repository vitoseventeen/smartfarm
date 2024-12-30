
package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

public class BrokenState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is broken and cannot be turned ON.");
    }

    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already OFF and broken.");
    }

    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is being repaired.");
        equipment.setState(new RepairedState());
    }

    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already broken.");
    }

    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is broken and cannot perform any actions.");
    }

    @Override
    public String toString() {
        return "BrokenState";
    }
}