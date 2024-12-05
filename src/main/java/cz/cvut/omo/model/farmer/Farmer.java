package cz.cvut.omo.model.farmer;

import cz.cvut.omo.model.task.Task;
import cz.cvut.omo.state.farmer.FarmerState;

import java.util.List;

public class Farmer {
    private String name;
    private int age;
    private FarmerState currentState;
    private List<Task> tasks;

    public Farmer(String name, int age, FarmerState initialState, List<Task> tasks) {
        this.name = name;
        this.age = age;
        this.currentState = initialState;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
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
