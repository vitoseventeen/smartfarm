package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

/**
 * Represents the state of equipment when it is turned off.
 * In this state, the equipment cannot perform actions but can transition to other states such as on or broken.
 */
public class OffState implements EquipmentState {

    /**
     * Turns on the equipment and transitions it to the OnState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is turning ON.");
        equipment.setState(new OnState());
    }

    /**
     * Logs that the equipment is already off.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already OFF.");
    }

    /**
     * Logs that the equipment does not need repairs while in the off state.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is OFF and doesn't need repairs.");
    }

    /**
     * Simulates a breakdown of the equipment and transitions it to the BrokenState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is breaking down while OFF.");
        equipment.setState(new BrokenState());
    }

    /**
     * Logs that the equipment cannot perform actions while turned off.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is OFF and cannot perform any actions.");
    }

    /**
     * Returns the string representation of this state.
     *
     * @return The string "OffState".
     */
    @Override
    public String toString() {
        return "OffState";
    }
}
