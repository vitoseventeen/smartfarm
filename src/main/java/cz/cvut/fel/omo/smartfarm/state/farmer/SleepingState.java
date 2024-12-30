package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public class SleepingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is waking up and starting to work.");
        farmer.setState(new WorkingState());
    }

    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " cannot rest while sleeping.");
    }

    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already sleeping.");
    }
}