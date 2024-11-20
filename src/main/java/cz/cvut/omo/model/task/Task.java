package cz.cvut.omo.model.task;

public class Task {
    private TaskType type;
    private String description;


    public Task(TaskType type, String description) {
        this.type = type;
        this.description = description;
    }


    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
