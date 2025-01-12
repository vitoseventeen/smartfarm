package model;

import cz.cvut.fel.omo.smartfarm.factory.BuildingFactory;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildingFactoryTest {

    private BuildingFactory buildingFactory;

    @BeforeEach
    public void setUp() {
        buildingFactory = new BuildingFactory();
    }

    @Test
    public void testCreateBarn() {
        Building barn = buildingFactory.createBuilding(BuildingType.BARN.toString(), "Barn1", 100);
        assertTrue(barn instanceof Barn, "Expected a Barn, but got: " + barn.getClass().getSimpleName());
    }

    @Test
    public void testCreateGreenhouse() {
        Building greenhouse = buildingFactory.createBuilding(BuildingType.GREENHOUSE.toString(), "Greenhouse1", 50);
        assertTrue(greenhouse instanceof Greenhouse, "Expected a Greenhouse, but got: " + greenhouse.getClass().getSimpleName());
    }

    @Test
    public void testCreateHouse() {
        Building house = buildingFactory.createBuilding(BuildingType.HOUSE.toString(), "House1", 10);
        assertTrue(house instanceof House, "Expected a House, but got: " + house.getClass().getSimpleName());
    }

    @Test
    public void testCreateStable() {
        Building stable = buildingFactory.createBuilding(BuildingType.STABLE.toString(), "Stable1", 20);
        assertTrue(stable instanceof Stable, "Expected a Stable, but got: " + stable.getClass().getSimpleName());
    }

    @Test
    public void testCreateWarehouse() {
        Building warehouse = buildingFactory.createBuilding(BuildingType.WAREHOUSE.toString(), "Warehouse1", 200);
        assertTrue(warehouse instanceof Warehouse, "Expected a Warehouse, but got: " + warehouse.getClass().getSimpleName());
    }

    @Test
    public void testCreateWorkshop() {
        Building workshop = buildingFactory.createBuilding(BuildingType.WORKSHOP.toString(), "Workshop1", 30);
        assertTrue(workshop instanceof Workshop, "Expected a Workshop, but got: " + workshop.getClass().getSimpleName());
    }

    @Test
    public void testCreateUnknownBuilding() {
        assertThrows(IllegalArgumentException.class, () -> buildingFactory.create("unknown"));
    }
}
