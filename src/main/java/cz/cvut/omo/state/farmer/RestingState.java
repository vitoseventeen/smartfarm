package cz.cvut.omo.state.farmer;

import cz.cvut.omo.model.farmer.Farmer;

public class RestingState implements FarmerState {
    @Override
    public void work(Farmer farmer) {
        System.out.println(farmer.getName() + " feels rested and starts working.");
        farmer.setState(new WorkingState());
    }

    @Override
    public void rest(Farmer farmer) {
        System.out.println(farmer.getName() + " is already resting.");
    }

    @Override
    public void sleep(Farmer farmer) {
        System.out.println(farmer.getName() + " goes to sleep after resting.");
        farmer.setState(new SleepingState());
    }
}