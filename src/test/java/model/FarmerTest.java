package model;

import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.farmer.FarmerStatus;
import cz.cvut.omo.model.task.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static cz.cvut.omo.model.task.TaskType.FEEDING_ANIMALS;
import static cz.cvut.omo.model.task.TaskType.PLANTING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FarmerTest {
    @Test
    public void testFarmerInitialization() {
        Farmer farmer = new Farmer("John", 50, FarmerStatus.RESTING, List.of());
        assertEquals("John", farmer.getName(), "Farmer name should be 'John'");
        assertEquals(50, farmer.getAge(), "Farmer age should be 50");
        assertEquals(FarmerStatus.RESTING, farmer.getCurrentAction(), "Farmer status should be 'RESTING'");
        assertEquals(0, farmer.getTasks().size(), "Farmer should have no tasks");
    }

    @Test
    public void testFarmerStatus() {
        Farmer farmer = new Farmer("Abe", 35, FarmerStatus.SLEEPING, List.of());
        assertEquals(FarmerStatus.SLEEPING, farmer.getCurrentAction());
        farmer.setCurrentAction(FarmerStatus.WORKING);
        assertEquals(FarmerStatus.WORKING, farmer.getCurrentAction());
        farmer.setCurrentAction(FarmerStatus.RESTING);
        assertEquals(FarmerStatus.RESTING, farmer.getCurrentAction());
    }

    @Test
    public void testFarmerTasks() {
        Farmer farmer = new Farmer("William", 41, FarmerStatus.WORKING, List.of());
        farmer.setTasks(List.of(new Task(PLANTING, "Farmer should plant 10 trees"), new Task(FEEDING_ANIMALS, "Farmer should feed 5 cows")));
        assertEquals(2, farmer.getTasks().size());
        assertEquals(PLANTING, farmer.getTasks().get(0).getType());
        assertEquals(FEEDING_ANIMALS, farmer.getTasks().get(1).getType());
    }
}
