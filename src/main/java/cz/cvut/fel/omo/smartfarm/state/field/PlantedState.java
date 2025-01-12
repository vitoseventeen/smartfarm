package cz.cvut.fel.omo.smartfarm.state.field;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.logging.Logger;

/**
 * Represents the state of a field that has been planted.
 * In this state, the field is growing crops and cannot be replanted or harvested immediately.
 * Pesticides can be applied to prepare the field for better crop protection.
 */
public class PlantedState implements FieldState {
    private static final Logger logger = Logger.getLogger(PlantedState.class.getName());

    /**
     * Logs that the field is already planted and cannot be replanted.
     *
     * @param field The field instance.
     */
    @Override
    public void plant(Field field) {
        AppLogger.getInstance().logInfo("The field is already planted.");
    }

    /**
     * Logs that the field is not ready for harvesting as the crops are still growing.
     *
     * @param field The field instance.
     */
    @Override
    public void harvest(Field field) {
        AppLogger.getInstance().logInfo("The field is not ready for harvesting.");
    }

    /**
     * Applies pesticides to the field and transitions it to the PesticideAppliedState.
     * Logs the action.
     *
     * @param field The field instance.
     */
    @Override
    public void applyPesticides(Field field) {
        field.setState(new PesticideAppliedState());
        AppLogger.getInstance().logInfo("The field is now ready for applying pesticides.");
    }
}
