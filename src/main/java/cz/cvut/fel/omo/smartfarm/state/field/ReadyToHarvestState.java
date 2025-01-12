package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

/**
 * Represents the state of a field that is ready to be harvested.
 * In this state, the field cannot be replanted or treated with pesticides but can transition to a free state after harvesting.
 */
public class ReadyToHarvestState implements FieldState {
    private static final Logger logger = Logger.getLogger(ReadyToHarvestState.class.getName());

    /**
     * Logs that planting is not allowed in a field that is ready to harvest.
     *
     * @param field The field instance.
     */
    @Override
    public void plant(Field field) {
        AppLogger.getInstance().logInfo("The field is already planted.");
    }

    /**
     * Harvests the crops in the field and transitions it to the FreeState.
     * Logs the action.
     *
     * @param field The field instance.
     */
    @Override
    public void harvest(Field field) {
        field.setState(new FreeState());
        AppLogger.getInstance().logInfo("The field was harvested.");
    }

    /**
     * Logs that applying pesticides is not allowed in a field that is ready to harvest.
     *
     * @param field The field instance.
     */
    @Override
    public void applyPesticides(Field field) {
        AppLogger.getInstance().logInfo("The field is not ready for applying pesticides.");
    }
}
