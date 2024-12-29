package model;

import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildTest {
    @Test
    public void testBarnInitialization() {
        Barn barn = new Barn("My Barn", 100);
        assertEquals("My Barn", barn.getName(), "Barn name should be 'My Barn'");
        assertEquals(50, barn.getArea(), "Barn area should be 50 sq.m");
        assertEquals(BuildingType.BARN, barn.getType(), "Building type should be 'BARN'");
        assertEquals(100, barn.getCapacity(), "Barn capacity should be 100");
        assertEquals(0, barn.getCurrentUsage(), "Initial current usage should be 0");
    }

    @Test
    public void testStableInitialization() {
        Stable stable = new Stable("My Stable", 50, Arrays.asList());
        assertEquals("My Stable", stable.getName(), "Stable name should be 'My Stable'");
        assertEquals(40, stable.getArea(), "Stable area should be 40 sq.m");
        assertEquals(BuildingType.STABLE, stable.getType(), "Building type should be 'STABLE'");
        assertEquals(50, stable.getCapacity(), "Stable capacity should be 50");
        assertEquals(0, stable.getCurrentUsage(), "Initial current usage should be 0");
    }

    @Test
    public void testHouseInitialization() {
        House house = new House("My House", 100, List.of(new Farmer("John", 30, new RestingState(), new ArrayList<>())));
        assertEquals("My House", house.getName(), "House name should be 'My House'");
        assertEquals(100, house.getArea(), "House area should be 100 sq.m");
        assertEquals(BuildingType.HOUSE, house.getType(), "Building type should be 'HOUSE'");
        assertEquals(1, house.getCapacity(), "House capacity should be 1");
        assertEquals(1, house.getFarmers().size(), "Number of farmers should be 1");
    }


    @Test
    public void testWorkshopInitialization() {
        Workshop workshop = new Workshop("My Workshop", 10);
        assertEquals("My Workshop", workshop.getName(), "Workshop name should be 'My Workshop'");
        assertEquals(100, workshop.getArea(), "Workshop area should be 100 sq.m");
        assertEquals(BuildingType.WORKSHOP, workshop.getType(), "Building type should be 'WORKSHOP'");
        assertEquals(10, workshop.getCapacity(), "Workshop capacity should be 10");
        assertEquals(0, workshop.getCurrentUsage(), "Initial current usage should be 0");
    }

    @Test
    public void testGreenhouseInitialization() {
        Greenhouse greenhouse = new Greenhouse("My Greenhouse", 3);
        assertEquals("My Greenhouse", greenhouse.getName(), "Greenhouse name should be 'My Greenhouse'");
        assertEquals(50, greenhouse.getArea(), "Greenhouse area should be 50 sq.m");
        assertEquals(BuildingType.GREENHOUSE, greenhouse.getType(), "Building type should be 'GREENHOUSE'");
        assertEquals(3, greenhouse.getCapacity(), "Greenhouse capacity should be 3");
        assertEquals(0, greenhouse.getCurrentUsage(), "Initial current usage should be 0");
    }

    @Test
    public void testWarehouseInitialization() {
        Warehouse warehouse = new Warehouse("My Warehouse", 20);
        assertEquals("My Warehouse", warehouse.getName(), "Warehouse name should be 'My Warehouse'");
        assertEquals(200, warehouse.getArea(), "Warehouse area should be 200 sq.m");
        assertEquals(BuildingType.WAREHOUSE, warehouse.getType(), "Building type should be 'WAREHOUSE'");
        assertEquals(20, warehouse.getCapacity(), "Warehouse capacity should be 20");
        assertEquals(0, warehouse.getCurrentUsage(), "Initial current usage should be 0");
    }

    @Test
    public void testStableInitializationWithAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(AnimalFactory.createAnimal("pig"));
        animals.add(AnimalFactory.createAnimal("Cow"));
        Stable stable = new Stable("My Stable", 50, animals);
        assertEquals("My Stable", stable.getName(), "Stable name should be 'My Stable'");
        assertEquals(40, stable.getArea(), "Stable area should be 40 sq.m");
        assertEquals(BuildingType.STABLE, stable.getType(), "Building type should be 'STABLE'");
        assertEquals(50, stable.getCapacity(), "Stable capacity should be 50");
        assertEquals(2, stable.getCurrentUsage(), "Initial current usage should be 2");
    }
}
