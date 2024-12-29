package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

public class ReadyToHarvestState implements FieldState {
    private static final Logger logger = Logger.getLogger(ReadyToHarvestState.class.getName());
    @Override
    public void plant(Field field) {
        System.out.println("The field is already planted.");
    }

    @Override
    public void harvest(Field field) {
        field.setState(new FreeState());
        System.out.println("The field was harvested.");
    }

    @Override
    public void applyPesticides(Field field) {
        System.out.println("The field is not ready for applying pesticides.");
    }
}
