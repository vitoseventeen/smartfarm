package cz.cvut.omo.state.farmer;

import cz.cvut.omo.model.farmer.Farmer;

public class SleepingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        System.out.println(farmer.getName() + " is waking up and starting to work.");
        farmer.setState(new WorkingState());
    }

    @Override
    public void rest(Farmer farmer) {
        System.out.println(farmer.getName() + " cannot rest while sleeping.");
    }

    @Override
    public void sleep(Farmer farmer) {
        System.out.println(farmer.getName() + " is already sleeping.");
    }
}