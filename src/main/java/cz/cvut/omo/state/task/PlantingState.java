package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class PlantingState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Planting crops. Description: " + task.getDescription());
    }
}