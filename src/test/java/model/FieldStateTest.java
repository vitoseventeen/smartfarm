package model;

import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.state.field.FreeState;
import cz.cvut.fel.omo.smartfarm.state.field.PlantedState;
import cz.cvut.fel.omo.smartfarm.state.field.ReadyToHarvestState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldStateTest {
    @Test
    public void testFieldInitialization() {
        Field field = new Field("Corn", 100);
        assertTrue(field.getState() instanceof FreeState, "Field should initialize in FreeState.");
    }

    @Test
    public void testPlantField() {
        Field field = new Field("Corn", 100);
        field.plant();
        assertTrue(field.getState() instanceof PlantedState, "Field should transition to PlantedState after planting.");
    }

    @Test
    public void testHarvestField() {
        Field field = new Field("Corn", 100);
        field.plant();
        field.applyPesticides();
        field.setState(new ReadyToHarvestState());
        field.harvest();
        assertTrue(field.getState() instanceof FreeState, "Field should transition to FreeState after harvesting.");
    }

    @Test
    public void testApplyPesticides() {
        Field field = new Field("Corn", 100);
        field.plant();
        field.applyPesticides();
        assertTrue(field.getState().getClass().getSimpleName().equals("PesticideAppliedState"),
                "Field should transition to PesticideAppliedState after applying pesticides.");
    }

    @Test
    public void testInvalidHarvestInFreeState() {
        Field field = new Field("Corn", 100);
        field.harvest();
        assertTrue(field.getState() instanceof FreeState, "Field should remain in FreeState after invalid harvest.");
    }

    @Test
    public void testInvalidPlantInPlantedState() {
        Field field = new Field("Corn", 100);
        field.plant();
        field.plant();
        assertTrue(field.getState() instanceof PlantedState, "Field should remain in PlantedState after invalid planting.");
    }
}
