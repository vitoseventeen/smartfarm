package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.SleepingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;

/**
 * Observes changes in the state of farmers and logs notifications based on the current state.
 * This observer is crucial for monitoring farmer activities and their effects on farm operations.
 */
public class FarmerObserver extends Observer<FarmerState> {

    /**
     * Constructs a FarmerObserver with a reference to the subject it should observe.
     *
     * @param subject The subject that this observer will monitor for state changes, typically a farmer.
     */
    public FarmerObserver(Subject<FarmerState> subject) {
        super(subject);
    }

    /**
     * Called when the observed subject's state changes.
     * Logs different messages depending on the current state of the farmer.
     */
    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();
        AppLogger logger = AppLogger.getInstance();

        switch (state) {
            case WorkingState working -> logger.logHint("The farmer is currently working.");
            case SleepingState sleeping -> logger.logHint("The farmer is sleeping.");
            case RestingState resting -> logger.logHint("The farmer is resting.");
            default -> logger.logError("The farmer is in an unknown or unsupported state.");
        }
    }
}
