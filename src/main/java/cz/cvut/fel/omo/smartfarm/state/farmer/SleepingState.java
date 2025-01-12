package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

/**
 * Represents the sleeping state of a farmer in the smart farm system.
 * In this state, the farmer cannot work or rest until they wake up.
 */
public class SleepingState implements FarmerState {

    /**
     * Wakes the farmer up and transitions them to the working state.
     * Logs the action.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void work(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is waking up and starting to work.");
        farmer.setState(new WorkingState());
    }

    /**
     * Logs that the farmer cannot rest while already sleeping.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void rest(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " cannot rest while sleeping.");
    }

    /**
     * Logs that the farmer is already sleeping.
     *
     * @param farmer The farmer instance.
     */
    @Override
    public void sleep(Farmer farmer) {
        AppLogger.getInstance().logInfo(farmer.getName() + " is already sleeping.");
    }
}
