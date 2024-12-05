package cz.cvut.omo.state.farmer;

import cz.cvut.omo.model.farmer.Farmer;

public class WorkingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        System.out.println(farmer.getName() + " is already working.");
    }

    @Override
    public void rest(Farmer farmer) {
        System.out.println(farmer.getName() + " is taking a rest after working.");
        farmer.setState(new RestingState());
    }

    @Override
    public void sleep(Farmer farmer) {
        System.out.println(farmer.getName() + " is too tired from working and goes to sleep.");
        farmer.setState(new SleepingState());
    }
}
