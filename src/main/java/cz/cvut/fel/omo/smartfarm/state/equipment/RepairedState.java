package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

/**
 * Represents the state of equipment after it has been repaired.
 * In this state, the equipment is functional and can transition to other states such as on, off, or broken.
 */
public class RepairedState implements EquipmentState {

    /**
     * Turns on the equipment and transitions it to the OnState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is repaired and turning ON.");
        equipment.setState(new OnState());
    }

    /**
     * Turns off the equipment and transitions it to the OffState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is OFF after repairs.");
        equipment.setState(new OffState());
    }

    /**
     * Logs that the equipment is already in a repaired state and does not need further repairs.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already repaired.");
    }

    /**
     * Simulates a breakdown of the equipment and transitions it to the BrokenState.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is breaking down again.");
        equipment.setState(new BrokenState());
    }

    /**
     * Logs that the equipment is repaired and ready to perform its designated actions.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is repaired and ready to perform actions.");
    }

    /**
     * Returns the string representation of this state.
     *
     * @return The string "RepairedState".
     */
    @Override
    public String toString() {
        return "RepairedState";
    }
}
