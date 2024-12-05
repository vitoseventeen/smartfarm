package cz.cvut.omo.state.task;

import cz.cvut.omo.model.task.Task;

public interface TaskState {
    void performAction(Task task);
}
