package cz.cvut.fel.omo.smartfarm.state.equipment;

import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;

/**
 * Interface defining the contract for various states of equipment in the smart farm system.
 * Each state implements behavior for turning the equipment on or off, repairing it,
 * handling breakdowns, and performing specific actions.
 */
public interface EquipmentState {

    /**
     * Turns on the equipment. Behavior depends on the current state of the equipment.
     *
     * @param equipment The equipment instance.
     */
    void turnOn(Equipment equipment);

    /**
     * Turns off the equipment. Behavior depends on the current state of the equipment.
     *
     * @param equipment The equipment instance.
     */
    void turnOff(Equipment equipment);

    /**
     * Repairs the equipment, potentially transitioning it to a functional state.
     *
     * @param equipment The equipment instance.
     */
    void repair(Equipment equipment);

    /**
     * Handles the breakdown of the equipment, transitioning it to a broken state if applicable.
     *
     * @param equipment The equipment instance.
     */
    void breakDown(Equipment equipment);

    /**
     * Performs an action with the equipment. Behavior depends on the current state of the equipment.
     *
     * @param equipment The equipment instance.
     */
    void performAction(Equipment equipment);
}
