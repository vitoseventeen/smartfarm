package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.equipment.BrokenState;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;

/**
 * Observes changes in the state of equipment and logs appropriate messages based on the state.
 * This observer is part of the observer pattern implementation for state monitoring.
 */
public class EquipmentObserver extends Observer<EquipmentState> {

    /**
     * Constructs an EquipmentObserver with a reference to the subject it should observe.
     *
     * @param subject The subject that this observer will monitor for state changes.
     */
    public EquipmentObserver(Subject<EquipmentState> subject) {
        super(subject);
    }

    /**
     * Called when the observed subject's state changes.
     * Logs different messages depending on the current state of the equipment.
     */
    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();
        AppLogger logger = AppLogger.getInstance();

        switch (state) {
            case OnState onState -> logger.logHint("Equipment is working!");
            case OffState offState -> logger.logHint("Equipment is turned off!");
            case BrokenState brokenState -> logger.logHint("Equipment is broken!");
            default -> logger.logError("Unknown equipment state.");
        }
    }
}
