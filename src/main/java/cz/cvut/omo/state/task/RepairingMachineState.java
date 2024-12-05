package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class RepairingMachineState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Repairing machine. Description: " + task.getDescription());
    }
}
