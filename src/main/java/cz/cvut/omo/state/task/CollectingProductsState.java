package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public class CollectingProductsState implements TaskState {
    @Override
    public void performAction(Task task) {
        System.out.println("Task: Collecting products from animals. Description: " + task.getDescription());
    }
}
