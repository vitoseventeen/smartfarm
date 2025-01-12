package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

/**
 * Handles events related to the field within the smart farm system.
 * This handler responds to field-specific events such as planting crops, harvesting crops, and applying pesticides.
 * If an event cannot be handled, it is passed to the next handler in the chain of responsibility.
 */
public class FieldEventHandler extends EventHandler {
    private final Field field;

    /**
     * Constructs a FieldEventHandler with a specific field.
     *
     * @param field The field that will be affected by the events.
     */
    public FieldEventHandler(Field field) {
        this.field = field;
    }

    /**
     * Handles field-related events by invoking actions on the field instance based on the event type.
     * If the event is not related to the field, it is passed along to the next handler in the chain.
     *
     * @param event The event to be handled, expected to be one of the field-related types.
     */
    @Override
    public void handleEvent(Event event) {
        switch (event.getType()) {
            case PLANT_CROPS:
                field.plant();
                break;

            case HARVEST_CROPS:
                field.harvest();
                break;

            case APPLY_PESTICIDE:
                field.applyPesticides();
                break;

            default:
                // Pass the event to the next handler in the chain if this one can't process it
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
