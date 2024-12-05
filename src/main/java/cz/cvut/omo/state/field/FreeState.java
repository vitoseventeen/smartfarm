package cz.cvut.omo.state.field;

import cz.cvut.omo.model.field.Field;

public class FreeState implements FieldState {
    @Override
    public void plant(Field field) {
        field.setState(new PlantedState());
        System.out.println("The field has been planted.");
    }

    @Override
    public void harvest(Field field) {
        System.out.println("The field is free. Nothing to harvest.");
    }

    @Override
    public void applyPesticides(Field field) {
        System.out.println("The field is free. No need for pesticides.");
    }
}
