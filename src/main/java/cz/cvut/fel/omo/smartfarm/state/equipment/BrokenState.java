package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

/**
 * Represents the state of equipment when it is broken.
 * In this state, the equipment cannot perform actions or be turned on/off but can be repaired.
 */
public class BrokenState implements EquipmentState {

    /**
     * Attempts to turn on the equipment, but logs that the equipment is broken and cannot be turned on.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOn(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is broken and cannot be turned ON.");
    }

    /**
     * Attempts to turn off the equipment, but logs that it is already off and broken.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void turnOff(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already OFF and broken.");
    }

    /**
     * Repairs the equipment and transitions it to the repaired state.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void repair(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is being repaired.");
        equipment.setState(new RepairedState());
    }

    /**
     * Logs that the equipment is already broken and cannot break down further.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void breakDown(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is already broken.");
    }

    /**
     * Attempts to perform an action with the equipment, but logs that the equipment is broken.
     *
     * @param equipment The equipment instance.
     */
    @Override
    public void performAction(Equipment equipment) {
        AppLogger.getInstance().logInfo(equipment.getName() + " is broken and cannot perform any actions.");
    }

    /**
     * Returns the string representation of this state.
     *
     * @return The string "BrokenState".
     */
    @Override
    public String toString() {
        return "BrokenState";
    }
}
