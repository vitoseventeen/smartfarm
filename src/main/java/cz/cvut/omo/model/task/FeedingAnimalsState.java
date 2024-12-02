package cz.cvut.omo.model.task;

public class FeedingAnimalsState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Feeding animals. Description: " + task.getDescription());
    }
}
