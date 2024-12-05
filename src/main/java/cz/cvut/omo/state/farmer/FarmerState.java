package cz.cvut.omo.state.farmer;

import cz.cvut.omo.model.farmer.Farmer;

public interface FarmerState {
    void work(Farmer farmer);
    void rest(Farmer farmer);
    void sleep(Farmer farmer);
}
