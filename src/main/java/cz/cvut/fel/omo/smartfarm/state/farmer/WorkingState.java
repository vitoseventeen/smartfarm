package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

/**
 * Represents the working state of a farmer in the smart farm system.
 * In this state, the farmer is actively working and can transition to resting or sleeping states.
 */
public class WorkingState implements FarmerState {

    /**
     * Logs that the farmer is already working.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already working.");
    }

    /**
     * Transitions the farmer from working to resting and logs the action.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is taking a rest after working.");
        farmer.setState(new RestingState());
    }

    /**
     * Transitions the farmer from working to sleeping and logs the action.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is too tired from working and goes to sleep.");
        farmer.setState(new SleepingState());
    }
}
