package model;

import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.SleepingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FarmerStateTest {
    @Test
    public void testFarmerInitialization() {
        Farmer farmer = new Farmer("John", 30, new SleepingState());
        assertTrue(farmer.getState() instanceof SleepingState, "Farmer should initialize in SleepingState.");
    }

    @Test
    public void testFarmerWorkTransition() {
        Farmer farmer = new Farmer("John", 30, new RestingState());
        farmer.work();
        assertTrue(farmer.getState() instanceof WorkingState, "Farmer should transition to WorkingState after working.");
    }

    @Test
    public void testFarmerRestTransition() {
        Farmer farmer = new Farmer("John", 30, new WorkingState());
        farmer.rest();
        assertTrue(farmer.getState() instanceof RestingState, "Farmer should transition to RestingState after resting.");
    }

    @Test
    public void testFarmerSleepTransition() {
        Farmer farmer = new Farmer("John", 30, new RestingState());
        farmer.sleep();
        assertTrue(farmer.getState() instanceof SleepingState, "Farmer should transition to SleepingState after sleeping.");
    }

    @Test
    public void testInvalidActionWhileSleeping() {
        Farmer farmer = new Farmer("John", 30, new SleepingState());
        farmer.rest();
        assertTrue(farmer.getState() instanceof SleepingState, "Farmer should remain in SleepingState after invalid rest action.");
    }

    @Test
    public void testInvalidActionWhileWorking() {
        Farmer farmer = new Farmer("John", 30, new WorkingState());
        farmer.work();
        assertTrue(farmer.getState() instanceof WorkingState, "Farmer should remain in WorkingState after invalid work action.");
    }
}
