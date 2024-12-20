package cz.cvut.omo.model.farmer;

import cz.cvut.omo.model.task.Task;
import cz.cvut.omo.state.farmer.FarmerState;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private final String name;
    private final int age;
    private FarmerState currentState;
    private List<Task> tasks;

    public Farmer(String name, int age, FarmerState initialState, List<Task> tasks) {
        this.name = name;
        this.age = age;
        this.currentState = initialState;
        this.tasks = new ArrayList<>(tasks);
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

    public void setTasks(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks); // Use a mutable list
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
