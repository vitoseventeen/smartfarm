package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

public interface FarmerState {
    void work(Farmer farmer);
    void rest(Farmer farmer);
    void sleep(Farmer farmer);
}
