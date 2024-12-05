package cz.cvut.omo.state.field;

import cz.cvut.omo.model.field.Field;

public class PlantedState implements FieldState {
    @Override
    public void plant(Field field) {
        System.out.println("The field is already planted.");
    }

    @Override
    public void harvest(Field field) {
        System.out.println("The field is not ready for harvest.");
    }

    @Override
    public void applyPesticides(Field field) {
        field.setState(new PesticideAppliedState());
        System.out.println("Pesticides have been applied to the field.");
    }
}
