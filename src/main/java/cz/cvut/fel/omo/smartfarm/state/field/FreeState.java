package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

/**
 * Represents the free state of a field in the smart farm system.
 * In this state, the field is ready for planting and does not require harvesting or pesticide application.
 */
public class FreeState implements FieldState {
    private static final Logger logger = Logger.getLogger(FreeState.class.getName());

    /**
     * Plants crops in the field and transitions it to the PlantedState.
     *
     * @param field The field instance.
     */
    @Override
    public void plant(Field field) {
        field.setState(new PlantedState());
        AppLogger.getInstance().logInfo("The field is now planted.");
    }

    /**
     * Logs that harvesting is not applicable for a free field.
     *
     * @param field The field instance.
     */
    @Override
    public void harvest(Field field) {
        AppLogger.getInstance().logInfo("The field is free. No need for harvesting.");
    }

    /**
     * Logs that applying pesticides is not applicable for a free field.
     *
     * @param field The field instance.
     */
    @Override
    public void applyPesticides(Field field) {
        AppLogger.getInstance().logInfo("The field is free. No need for applying pesticides.");
    }
}
