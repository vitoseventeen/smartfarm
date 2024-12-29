package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

public class FreeState implements FieldState {
    private static final Logger logger = Logger.getLogger(FreeState.class.getName());
    @Override
    public void plant(Field field) {
        field.setState(new PlantedState());
        logger.info("The field is now planted.");
    }

    @Override
    public void harvest(Field field) {
        logger.info("The field is free. No need for harvesting.");
    }

    @Override
    public void applyPesticides(Field field) {
        logger.info("The field is free. No need for applying pesticides.");
    }
}
