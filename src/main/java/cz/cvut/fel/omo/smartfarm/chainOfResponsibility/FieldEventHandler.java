package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

public class FieldEventHandler extends EventHandler {
    private final Field field;

    public FieldEventHandler(Field field) {
        this.field = field;
    }

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
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
