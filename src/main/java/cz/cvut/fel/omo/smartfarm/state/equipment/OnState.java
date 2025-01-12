package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

/**
 * Represents the state of equipment when it is turned on.
 * In this state, the equipment can perform actions and transition to other states such as off or broken.
 */
public class OnState implements EquipmentState {

    /**
     * Logs that the equipment is already turned on.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already ON.");
    }

    /**
     * Turns off the equipment and transitions it to the OffState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is turning OFF.");
        equipment.setState(new OffState());
    }

    /**
     * Logs that the equipment does not need repairs while in the on state.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is ON and doesn't need repairs.");
    }

    /**
     * Simulates a breakdown of the equipment and transitions it to the BrokenState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is breaking down.");
        equipment.setState(new BrokenState());
    }

    /**
     * Logs that the equipment is performing its designated action.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is performing its action.");
    }

    /**
     * Returns the string representation of this state.
     *
     * @return The string "OnState".
     */
    @Override
    public String toString() {
        return "OnState";
    }
}
