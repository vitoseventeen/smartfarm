/**
 * Handles events related to {@link Equipment} in the chain of responsibility.
 * This handler manages equipment-specific actions such as turning on/off,
 * repairing, refueling, and handling breakdowns.
 */
package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;

public class EquipmentEventHandler extends EventHandler {

    /**
     * The equipment instance managed by this handler.
     */
    private Equipment equipment;

    /**
     * Creates an EquipmentEventHandler for the specified equipment.
     *
     * @param equipment the equipment to be managed by this handler
     */
    public EquipmentEventHandler(Equipment equipment) {
        this.equipment = equipment;
    }

    /**
     * Handles an event directed at the equipment.
     * If the event type does not match, it delegates to the next handler in the chain.
     *
     * @param event the event to be handled
     */
    @Override
    public void handleEvent(Event event) {
        switch (event.getType()) {
            case TURN_ON:
                equipment.turnOn();
                break;

            case TURN_OFF:
                equipment.turnOff();
                break;

            case REPAIR:
                equipment.repair();
                break;

            case REFUEL:
                if (equipment instanceof Machine) {
                    ((Machine) equipment).setFuelLevel(100);
                    AppLogger.getInstance().logInfo(equipment.getName() + " is refueled to 100.");
                }
                break;

            case BREAK_DOWN:
                equipment.breakDown();
                break;

            case PERFORM_ACTION:
                equipment.performAction();
                break;

            default:
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
