package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

public class PesticideAppliedState implements FieldState {
    private static final Logger logger = Logger.getLogger(PesticideAppliedState.class.getName());
    @Override
    public void plant(Field field) {
        AppLogger.getInstance().logInfo("The field with pesticides is not ready for planting.");
    }

    @Override
    public void harvest(Field field) {
        AppLogger.getInstance().logInfo("The field with pesticides is not ready for harvesting.");
    }

    @Override
    public void applyPesticides(Field field) {
        AppLogger.getInstance().logInfo("The field already has pesticides applied.");
        field.setState(new ReadyToHarvestState());
    }
}
