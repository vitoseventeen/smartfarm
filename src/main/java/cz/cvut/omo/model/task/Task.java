package cz.cvut.omo.model.task;

public class Task {
    private TaskState state;  // Текущее состояние задачи
    private String description;

    public Task(TaskState state, String description) {
        this.state = state;
        this.description = description;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public TaskState getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void performAction() {
        state.performAction(this);
    }

    @Override
    public String toString() {
        return "Task{" +
                "state=" + state.getClass().getSimpleName() +
                ", description='" + description + '\'' +
                '}';
    }
}
