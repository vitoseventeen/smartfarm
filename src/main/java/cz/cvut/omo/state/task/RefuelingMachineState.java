package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class RefuelingMachineState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Refueling machine. Description: " + task.getDescription());
    }
}
