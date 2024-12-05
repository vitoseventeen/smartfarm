package cz.cvut.omo.model.task;

public class HarvestingState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Harvesting crops. Description: " + task.getDescription());
    }
}