package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public class RestingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " feels rested and starts working.");
        farmer.setState(new WorkingState());
    }

    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already resting.");
    }

    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " goes to sleep after resting.");
        farmer.setState(new SleepingState());
    }
}