// TODO: REWRITE TESTS
//package model;
//
//import cz.cvut.omo.model.farm.Farm;
//import cz.cvut.omo.model.animal.Animal;
//import cz.cvut.omo.model.build.Building;
//import cz.cvut.omo.model.equipment.Equipment;
//import cz.cvut.omo.model.farmer.Farmer;
//import cz.cvut.omo.model.field.Field;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//
//public class FarmTest {
//    @Test
//    public void testFarmInitialization() {
//        Field field = mock(Field.class);
//        Farmer farmer = mock(Farmer.class);
//        Building building = mock(Building.class);
//        Equipment equipment = mock(Equipment.class);
//        Animal animal = mock(Animal.class);
//
//        Farm farm = new Farm("My Farm",
//                Arrays.asList(field),
//                Arrays.asList(farmer),
//                Arrays.asList(building),
//                Arrays.asList(equipment),
//                Arrays.asList(animal));
//
//        assertEquals("My Farm", farm.getName(), "Farm name should be 'My Farm'");
//
//        assertEquals(1, farm.getFields().size(), "Farm should have 1 field");
//        assertEquals(1, farm.getFarmers().size(), "Farm should have 1 farmer");
//        assertEquals(1, farm.getBuildings().size(), "Farm should have 1 building");
//        assertEquals(1, farm.getEquipments().size(), "Farm should have 1 equipment");
//        assertEquals(1, farm.getAnimals().size(), "Farm should have 1 animal");
//    }
//
//    @Test
//    public void testSettersAndGetters() {
//        Field field = mock(Field.class);
//        Farmer farmer = mock(Farmer.class);
//        Building building = mock(Building.class);
//        Equipment equipment = mock(Equipment.class);
//        Animal animal = mock(Animal.class);
//
//        Farm farm = new Farm("My Farm",
//                Arrays.asList(field),
//                Arrays.asList(farmer),
//                Arrays.asList(building),
//                Arrays.asList(equipment),
//                Arrays.asList(animal));
//
//        farm.setName("Updated Farm");
//        assertEquals("Updated Farm", farm.getName(), "Farm name should be updated.");
//
//        Field newField = mock(Field.class);
//        farm.setFields(Arrays.asList(newField));
//        assertEquals(1, farm.getFields().size(), "Farm should have 1 field after update.");
//
//        Farmer newFarmer = mock(Farmer.class);
//        farm.setFarmers(Arrays.asList(newFarmer));
//        assertEquals(1, farm.getFarmers().size(), "Farm should have 1 farmer after update.");
//
//        Building newBuilding = mock(Building.class);
//        farm.setBuildings(Arrays.asList(newBuilding));
//        assertEquals(1, farm.getBuildings().size(), "Farm should have 1 building after update.");
//
//        Equipment newEquipment = mock(Equipment.class);
//        farm.setEquipments(Arrays.asList(newEquipment));
//        assertEquals(1, farm.getEquipments().size(), "Farm should have 1 equipment after update.");
//
//        Animal newAnimal = mock(Animal.class);
//        farm.setAnimals(Arrays.asList(newAnimal));
//        assertEquals(1, farm.getAnimals().size(), "Farm should have 1 animal after update.");
//    }
//
//}
