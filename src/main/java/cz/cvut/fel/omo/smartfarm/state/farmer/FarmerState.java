package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

/**
 * Interface defining the contract for various states of a farmer in the smart farm system.
 * Each state implements behavior for activities such as working, resting, and sleeping.
 */
public interface FarmerState {

    /**
     * Defines the behavior when the farmer works.
     * This method should be implemented to represent the actions taken when a farmer is in a working state.
     *
     * @param farmer The farmer instance.
     */
    void work(Farmer farmer);

    /**
     * Defines the behavior when the farmer rests.
     * This method should be implemented to represent the actions taken when a farmer is in a resting state.
     *
     * @param farmer The farmer instance.
     */
    void rest(Farmer farmer);

    /**
     * Defines the behavior when the farmer sleeps.
     * This method should be implemented to represent the actions taken when a farmer is in a sleeping state.
     *
     * @param farmer The farmer instance.
     */
    void sleep(Farmer farmer);
}
