package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.state.field.*;

public class FieldObserver extends Observer<FieldState> {


    public FieldObserver(Subject<FieldState> subject) {
        super(subject);
    }

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
