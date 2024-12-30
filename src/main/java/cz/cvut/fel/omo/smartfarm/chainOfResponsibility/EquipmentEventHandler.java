package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;

public class EquipmentEventHandler extends EventHandler {
    private Equipment equipment;

    public EquipmentEventHandler(Equipment equipment) {
        this.equipment = equipment;
    }

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
