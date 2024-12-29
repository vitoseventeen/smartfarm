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
                System.out.println("Planted crops on field: " + field.getCropType());
                break;

            case HARVEST_CROPS:
                field.harvest();
                System.out.println("Harvested crops from field: " + field.getCropType());
                break;

            case APPLY_PESTICIDE:
                field.applyPesticides();
                System.out.println("Applied pesticides on field: " + field.getCropType());
                break;

            default:
                if (nextHandler != null) {
                    nextHandler.handleEvent(event);
                }
        }
    }
}
