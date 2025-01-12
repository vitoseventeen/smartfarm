package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

/**
 * Represents the resting state of a farmer in the smart farm system.
 * In this state, the farmer can transition to working or sleeping, or continue resting.
 */
public class RestingState implements FarmerState {

    /**
     * Transitions the farmer from resting to working and logs the action.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " feels rested and starts working.");
        farmer.setState(new WorkingState());
    }

    /**
     * Logs that the farmer is already resting.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already resting.");
    }

    /**
     * Transitions the farmer from resting to sleeping and logs the action.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " goes to sleep after resting.");
        farmer.setState(new SleepingState());
    }
}
