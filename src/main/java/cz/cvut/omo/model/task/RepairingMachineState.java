package cz.cvut.omo.model.task;

public class RepairingMachineState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Repairing machine. Description: " + task.getDescription());
    }
}
