package cz.cvut.omo.model.farmer;

public interface FarmerState {
    void work(Farmer farmer);
    void rest(Farmer farmer);
    void sleep(Farmer farmer);
}
