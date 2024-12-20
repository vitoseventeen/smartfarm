package model;

import cz.cvut.omo.model.task.*;
import cz.cvut.omo.state.task.ApplyingPesticidesState;
import cz.cvut.omo.state.task.FeedingAnimalsState;
import cz.cvut.omo.state.task.HarvestingState;
import cz.cvut.omo.state.task.PlantingState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskStateTest {

    @Test
    public void testTaskInitialization() {
        Task task = new Task(new PlantingState(), "Planting corn");
        assertEquals(PlantingState.class, task.getState().getClass());
        assertEquals("Planting corn", task.getDescription());
    }

    @Test
    public void testTaskStateChange() {
        Task task = new Task(new PlantingState(), "Planting corn");
        assertEquals(PlantingState.class, task.getState().getClass(), "Initial state should be PlantingState");

        // Changing state to HarvestingState
        task.setState(new HarvestingState());
        assertEquals(HarvestingState.class, task.getState().getClass(), "State should change to HarvestingState");
    }

    @Test
    public void testTaskPerformActionInPlantingState() {
        Task task = new Task(new PlantingState(), "Planting tomatoes");
        task.performAction();  // Should print: Task: Planting crops. Description: Planting tomatoes
    }

    @Test
    public void testTaskPerformActionInHarvestingState() {
        Task task = new Task(new HarvestingState(), "Harvesting wheat");
        task.performAction();  // Should print: Task: Harvesting crops. Description: Harvesting wheat
    }

    @Test
    public void testTaskPerformActionInApplyingPesticidesState() {
        Task task = new Task(new ApplyingPesticidesState(), "Applying pesticides to crops");
        task.performAction();  // Should print: Task: Applying pesticides. Description: Applying pesticides to crops
    }

    @Test
    public void testTaskDescriptionUpdate() {
        Task task = new Task(new PlantingState(), "Planting corn");
        task.setDescription("Planting tomatoes");
        assertEquals("Planting tomatoes", task.getDescription(), "Description should be updated to 'Planting tomatoes'");
    }

    @Test
    public void testTaskStateAfterDescriptionChange() {
        Task task = new Task(new FeedingAnimalsState(), "Feeding cows");
        task.setDescription("Feeding goats");
        task.performAction();  // Should print: Task: Feeding animals. Description: Feeding goats
    }
}
