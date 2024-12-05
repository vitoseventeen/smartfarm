
package cz.cvut.omo.model.task;

public class ApplyingPesticidesState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Applying pesticides. Description: " + task.getDescription());
    }
}