package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

public class PlantedState implements FieldState {
    private static final Logger logger = Logger.getLogger(PlantedState.class.getName());
    @Override
    public void plant(Field field) {
        AppLogger.getInstance().logInfo("The field is already planted.");
    }

    @Override
    public void harvest(Field field) {
        AppLogger.getInstance().logInfo("The field is not ready for harvesting.");
    }

    @Override
    public void applyPesticides(Field field) {
        field.setState(new PesticideAppliedState());
        AppLogger.getInstance().logInfo("The field is now ready for applying pesticides.");
    }
}
