package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

/**
 * Represents the state of a field where pesticides have been applied.
 * In this state, the field is not ready for planting or harvesting but can transition to a ready-to-harvest state.
 */
public class PesticideAppliedState implements FieldState {
    private static final Logger logger = Logger.getLogger(PesticideAppliedState.class.getName());

    /**
     * Logs that planting is not possible in a field with pesticides applied.
     *
     * @param field The field instance.
     */
    @Override
    public void plant(Field field) {
        AppLogger.getInstance().logInfo("The field with pesticides is not ready for planting.");
    }

    /**
     * Logs that harvesting is not possible in a field with pesticides applied.
     *
     * @param field The field instance.
     */
    @Override
    public void harvest(Field field) {
        AppLogger.getInstance().logInfo("The field with pesticides is not ready for harvesting.");
    }

    /**
     * Logs that pesticides have already been applied to the field.
     * Transitions the field to the ReadyToHarvestState.
     *
     * @param field The field instance.
     */
    @Override
    public void applyPesticides(Field field) {
        AppLogger.getInstance().logInfo("The field already has pesticides applied.");
        field.setState(new ReadyToHarvestState());
    }
}
