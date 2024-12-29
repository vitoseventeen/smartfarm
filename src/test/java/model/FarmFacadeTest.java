//package model;
//
//import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
//import cz.cvut.fel.omo.smartfarm.facade.FarmFacade;
//import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
//import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
//import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
//import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
//import cz.cvut.fel.omo.smartfarm.model.field.Field;
//import cz.cvut.fel.omo.smartfarm.model.task.Task;
//import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
//import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;
//import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
//import cz.cvut.fel.omo.smartfarm.state.field.FreeState;
//import cz.cvut.fel.omo.smartfarm.state.field.PlantedState;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FarmFacadeTest {
//
//    @Test
//    void testAssignAllTasksToAllFarmers() {
//        Farmer farmer1 = new Farmer("Alice", 30, new RestingState(), new ArrayList<>());
//        Farmer farmer2 = new Farmer("Bob", 40, new RestingState(), new ArrayList<>());
////
////        Task task1 = new Task(new PlantingState(), "Plant field");
////        Task task2 = new Task(new HarvestingState(), "Harvest field");
//
//        FarmBuilder farmBuilder = new FarmBuilder()
//                .setName("Test Farm")
//                .addFarmer(farmer1)
//                .addFarmer(farmer2);
//
//        Farm farm = farmBuilder.build();
//        FarmFacade farmFacade = new FarmFacade(farm);
////
////        farmer1.getTasks().add(task1);
////        farmer1.getTasks().add(task2);
//
//        farmFacade.assignAllTasksToAllFarmers();
//
//        assertEquals(1, farmer1.getTasks().size(), "Farmer1 should have 1 task after redistribution.");
//        assertEquals(1, farmer2.getTasks().size(), "Farmer2 should have 1 task after redistribution.");
////        assertTrue(farmer1.getTasks().contains(task1) || farmer1.getTasks().contains(task2), "Farmer1 should have one of the tasks.");
////        assertTrue(farmer2.getTasks().contains(task1) || farmer2.getTasks().contains(task2), "Farmer2 should have the other task.");
//    }
//
//
//    @Test
//    void testPerformAllTasks() {
//        Farmer farmer = new Farmer("Charlie", 35, new RestingState(), new ArrayList<>(List.of(new Task(new PlantingState(), "Planting"))));
//        Field field = new Field("Corn Field", 100);
//
//        FarmBuilder farmBuilder = new FarmBuilder()
//                .setName("Test Farm")
//                .addFarmer(farmer)
//                .addField(field);
//
//        Farm farm = farmBuilder.build();
//        FarmFacade farmFacade = new FarmFacade(farm);
//
//        farmFacade.performAllTasks();
//
//        assertTrue(farmer.getTasks().isEmpty(), "Farmer's tasks should be empty after performing all tasks.");
//        assertTrue(field.getState() instanceof PlantedState, "Field should be in PlantedState after planting task.");
//    }
//
//
//    @Test
//    void testPlantAllFields() {
//        Field freeField = new Field("Free Field", 50);
//        freeField.setState(new FreeState());
//
//        Field alreadyPlantedField = new Field("Planted Field", 70);
//        alreadyPlantedField.setState(new PlantedState());
//
//        FarmBuilder farmBuilder = new FarmBuilder()
//                .setName("Farm for Planting Test")
//                .addField(freeField)
//                .addField(alreadyPlantedField);
//
//        Farm farm = farmBuilder.build();
//        FarmFacade farmFacade = new FarmFacade(farm);
//
//        farmFacade.plantAllFields();
//
//        assertTrue(freeField.getState() instanceof PlantedState, "FreeField should be in PlantedState.");
//        assertTrue(alreadyPlantedField.getState() instanceof PlantedState, "AlreadyPlantedField state should remain PlantedState.");
//    }
//
//    //TODO: IMPLEMENT AFTER IMPLEMENTING ANIMAL FEEDING
////    @Test
////    void testFeedAllAnimals() {
////
////    }
//
//    @Test
//    void testStartAllEquipment() {
//        Machine machine1 = new Machine("Tractor", 80);
//        machine1.turnOff();
//
//        FarmBuilder farmBuilder = new FarmBuilder()
//                .setName("Farm with Equipment")
//                .addEquipment(machine1);
//
//        Farm farm = farmBuilder.build();
//        FarmFacade farmFacade = new FarmFacade(farm);
//
//        farmFacade.startAllEquipment();
//
//        assertTrue(machine1.getState() instanceof OnState);
//    }
//
//    @Test
//    void testStopAllEquipment() {
//        Machine machine1 = new Machine("Tractor", 80);
//        machine1.turnOn();
//        Equipment equipment = machine1;
//
//        FarmBuilder farmBuilder = new FarmBuilder()
//                .setName("Farm with Equipment")
//                .addEquipment(equipment);
//
//        Farm farm = farmBuilder.build();
//        FarmFacade farmFacade = new FarmFacade(farm);
//
//        farmFacade.stopAllEquipment();
//
//        assertTrue(machine1.getState() instanceof OffState);
//    }
//}
