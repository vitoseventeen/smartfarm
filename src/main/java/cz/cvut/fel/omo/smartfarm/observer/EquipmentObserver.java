package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.equipment.BrokenState;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;

public class EquipmentObserver extends Observer<EquipmentState> {

    public EquipmentObserver(Subject<EquipmentState> subject) {
        super(subject);
    }

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
