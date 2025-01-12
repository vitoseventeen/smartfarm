package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.field.*;

/**
 * Observes changes in the state of agricultural fields and logs notifications based on the current state.
 * This observer is crucial for monitoring field conditions and ensuring timely actions are taken in field management.
 */
public class FieldObserver extends Observer<FieldState> {

    /**
     * Constructs a FieldObserver with a reference to the subject it should observe.
     *
     * @param subject The subject that this observer will monitor for state changes, typically a field.
     */
    public FieldObserver(Subject<FieldState> subject) {
        super(subject);
    }

    /**
     * Called when the observed subject's state changes.
     * Logs different messages depending on the current state of the field to inform about the field's readiness for various agricultural activities.
     */
    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();
        AppLogger logger = AppLogger.getInstance();

        switch (state) {
            case FreeState free -> logger.logHint("The field is free and ready for use.");
            case PlantedState planted -> logger.logHint("The field is planted and crops are growing.");
            case ReadyToHarvestState ready -> logger.logHint("The field is ready for harvesting.");
            case PesticideAppliedState pesticide -> logger.logHint("The field has been treated with pesticides.");
            default -> logger.logHint("The field is in an unknown or unsupported state.");
        }
    }
}
