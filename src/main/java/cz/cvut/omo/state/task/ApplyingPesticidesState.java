
package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class ApplyingPesticidesState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Applying pesticides. Description: " + task.getDescription());
    }
}