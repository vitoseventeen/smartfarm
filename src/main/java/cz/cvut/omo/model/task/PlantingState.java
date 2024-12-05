package cz.cvut.omo.model.task;

public class PlantingState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Planting crops. Description: " + task.getDescription());
    }
}