package model;

import cz.cvut.omo.model.task.Task;
import cz.cvut.omo.model.task.TaskType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void testTaskInitialization() {
        Task task = new Task(TaskType.PLANTING, "Planting corn");
        assertEquals(TaskType.PLANTING, task.getType());
        assertEquals("Planting corn", task.getDescription());
    }

    @Test
    public void testTaskSetType() {
        Task task = new Task(TaskType.PLANTING, "Planting corn");
        task.setType(TaskType.HARVESTING);
        assertEquals(TaskType.HARVESTING, task.getType());
    }

    @Test
    public void testTaskSetDescription() {
        Task task = new Task(TaskType.PLANTING, "Planting corn");
        task.setDescription("Harvesting corn");
        assertEquals("Harvesting corn", task.getDescription());
    }

}
