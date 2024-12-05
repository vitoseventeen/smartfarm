package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class FeedingAnimalsState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Feeding animals. Description: " + task.getDescription());
    }
}
