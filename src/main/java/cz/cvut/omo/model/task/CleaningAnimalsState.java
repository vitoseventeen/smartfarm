package cz.cvut.omo.model.task;

public class CleaningAnimalsState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Cleaning animals. Description: " + task.getDescription());
    }
}
