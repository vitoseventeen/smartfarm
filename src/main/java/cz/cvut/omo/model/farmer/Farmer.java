package cz.cvut.omo.model.farmer;

import cz.cvut.omo.model.task.Task;

import java.util.List;

public class Farmer {
    private String name;
    private int age;
    private FarmerStatus currentAction;
    private List<Task> tasks;

    public Farmer(String name, int age, FarmerStatus currentAction, List<Task> tasks) {
        this.name = name;
        this.age = age;
        this.currentAction = currentAction;
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", currentAction=" + currentAction +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public FarmerStatus getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(FarmerStatus currentAction) {
        this.currentAction = currentAction;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        if (tasks == null) return;
        this.tasks = tasks;
    }
}
