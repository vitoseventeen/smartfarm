package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.SleepingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;

public class FarmerObserver extends Observer<FarmerState> {


    public FarmerObserver(Subject<FarmerState> subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();
        AppLogger logger = AppLogger.getInstance();

        switch (state) {
            case WorkingState working -> logger.logHint("The field is free and ready for use.");
            case SleepingState sleeping -> logger.logHint("The field is planted and crops are growing.");
            case RestingState resting -> logger.logHint("The field is ready for harvesting.");
            default -> logger.logError("The field is in an unknown or unsupported state.");
        }


    }


}
