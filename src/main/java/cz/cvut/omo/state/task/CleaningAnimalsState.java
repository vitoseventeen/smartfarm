package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class CleaningAnimalsState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Cleaning animals. Description: " + task.getDescription());
    }
}
