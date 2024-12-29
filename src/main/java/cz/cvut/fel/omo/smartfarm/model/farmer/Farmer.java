package cz.cvut.fel.omo.smartfarm.model.farmer;

import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private final String name;
    private final int age;
    private FarmerState currentState;

    public Farmer(String name, int age, FarmerState initialState) {
        this.name = name;
        this.age = age;
        this.currentState = initialState;
    }

    public void work() {
        currentState.work(this);
    }

    public void rest() {
        currentState.rest(this);
    }

    public void sleep() {
        currentState.sleep(this);
    }

    public void setState(FarmerState state) {
        this.currentState = state;
    }

    public FarmerState getState() {
        return currentState;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", currentState=" + currentState.getClass().getSimpleName() +
                '}';
    }
}
