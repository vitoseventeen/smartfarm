//package model;
//
//import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
//import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
//import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
//import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;
//import cz.cvut.fel.omo.smartfarm.state.equipment.BrokenState;
//import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
//import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;
//import cz.cvut.fel.omo.smartfarm.state.equipment.RepairedState;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class EquipmentStateTest {
//    @BeforeAll
//    static void setUpLogger() {
//        AppLogger.setUpAppLogger();
//    }
//
//    @Test
//    public void testMachineInitialization() {
//        Equipment machine = new Machine("Tractor", 100);
//        assertTrue(machine.getState() instanceof OffState, "Machine should initialize in OffState.");
//    }
//
//    @Test
//    public void testMachineTurnOn() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.turnOn();
//        assertTrue(machine.getState() instanceof OnState, "Machine should transition to OnState after turning ON.");
//    }
//
//    @Test
//    public void testMachineBreakDown() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.breakDown();
//        assertTrue(machine.getState() instanceof BrokenState, "Machine should transition to BrokenState after breaking down.");
//    }
//
//    @Test
//    public void testMachineRepair() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.breakDown();
//        machine.repair();
//        assertTrue(machine.getState() instanceof RepairedState, "Machine should transition to RepairedState after being repaired.");
//    }
//
//    @Test
//    public void testMachinePerformActionWhileOff() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.performAction();
//        assertTrue(machine.getState() instanceof OffState, "Machine should remain in OffState after trying to perform an action while OFF.");
//    }
//
//    @Test
//    public void testMachinePerformActionWhileOn() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.turnOn();
//        machine.performAction();
//        assertTrue(machine.getState() instanceof OnState, "Machine should remain in OnState after performing an action.");
//    }
//
//
//    @Test
//    public void testToolInitialization() {
//        Equipment tool = new Tool("Hammer", "Manual");
//        assertTrue(tool.getState() instanceof OffState, "Tool should initialize in OffState.");
//    }
//
//    @Test
//    public void testToolTurnOn() {
//        Equipment tool = new Tool("Drill", "Electric");
//        tool.turnOn();
//        assertTrue(tool.getState() instanceof OnState, "Tool should transition to OnState after turning ON.");
//    }
//
//    @Test
//    public void testToolBreakDown() {
//        Equipment tool = new Tool("Drill", "Electric");
//        tool.breakDown();
//        assertTrue(tool.getState() instanceof BrokenState, "Tool should transition to BrokenState after breaking down.");
//    }
//
//    @Test
//    public void testToolRepair() {
//        Equipment tool = new Tool("Drill", "Electric");
//        tool.breakDown();
//        tool.repair();
//        assertTrue(tool.getState() instanceof RepairedState, "Tool should transition to RepairedState after being repaired.");
//    }
//
//    @Test
//    public void testToolPerformActionWhileOff() {
//        Equipment tool = new Tool("Hammer", "Manual");
//        tool.performAction();
//        assertTrue(tool.getState() instanceof OffState, "Tool should remain in OffState after trying to perform an action while OFF.");
//    }
//
//    @Test
//    public void testToolPerformActionWhileOn() {
//        Equipment tool = new Tool("Drill", "Electric");
//        tool.turnOn();
//        tool.performAction();
//        assertTrue(tool.getState() instanceof OnState, "Tool should remain in OnState after performing an action.");
//    }
//
//    @Test
//    public void testEquipmentCannotBeRepairedIfAlreadyRepaired() {
//        Equipment machine = new Machine("Tractor", 100);
//        machine.breakDown();
//        machine.repair();
//        machine.repair();
//        assertTrue(machine.getState() instanceof RepairedState, "Machine should remain in RepairedState after trying to repair again.");
//    }
//
//    @Test
//    public void testEquipmentCannotTurnOnIfBroken() {
//        Equipment tool = new Tool("Drill", "Electric");
//        tool.breakDown();
//        tool.turnOn();
//        assertTrue(tool.getState() instanceof BrokenState, "Tool should remain in BrokenState after trying to turn ON while broken.");
//    }
//}
