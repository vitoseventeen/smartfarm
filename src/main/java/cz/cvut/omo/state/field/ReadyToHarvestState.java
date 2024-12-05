package cz.cvut.omo.state.field;

import cz.cvut.omo.model.field.Field;

public class ReadyToHarvestState implements FieldState {
    @Override
    public void plant(Field field) {
        System.out.println("The field is ready for harvest. You need to harvest before planting.");
    }

    @Override
    public void harvest(Field field) {
        field.setState(new FreeState());
        System.out.println("The field has been harvested and is now free.");
    }

    @Override
    public void applyPesticides(Field field) {
        System.out.println("The field is ready for harvest. No need for pesticides.");
    }
}
