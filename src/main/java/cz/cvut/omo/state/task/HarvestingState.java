package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class HarvestingState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Harvesting crops. Description: " + task.getDescription());
    }
}