package cz.cvut.fel.omo.smartfarm.model.task;

public class Task {
    private String description;

    public Task(String description) {
        this.description = description;
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
                "description='" + description + '\'' +
                '}';
    }
}
