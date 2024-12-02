package cz.cvut.omo.model.task;

public class RefuelingMachineState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Refueling machine. Description: " + task.getDescription());
    }
}
