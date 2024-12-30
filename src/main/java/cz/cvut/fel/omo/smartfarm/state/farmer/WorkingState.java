package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public class WorkingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already working.");
    }

    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is taking a rest after working.");
        farmer.setState(new RestingState());
    }

    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is too tired from working and goes to sleep.");
        farmer.setState(new SleepingState());
    }
}
