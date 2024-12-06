package model;

import cz.cvut.omo.builder.FarmBuilder;
import cz.cvut.omo.model.animal.Animal;
import cz.cvut.omo.model.animal.Cow;
import cz.cvut.omo.model.build.Barn;
import cz.cvut.omo.model.build.Building;
import cz.cvut.omo.model.equipment.Equipment;
import cz.cvut.omo.model.equipment.Machine;
import cz.cvut.omo.model.farm.Farm;
import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.field.Field;
import cz.cvut.omo.state.farmer.WorkingState;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FarmBuilderTest {

    @Test
    void testFarmInitialization() {
        Field field = new Field("Wheat Field", 200);
        Farmer farmer = new Farmer("Jake Paul", 24, new WorkingState(), List.of());
        Building building = new Barn("Barn", 200);
        Equipment equipment = new Machine("Tractor", 52);
        Animal animal = new Cow(5);

        FarmBuilder farmBuilder = new FarmBuilder()
                .setName("Green Valley Farm")
                .addField(field)
                .addFarmer(farmer)
                .addBuilding(building)
                .addEquipment(equipment)
                .addAnimal(animal);

        Farm farm = farmBuilder.build();

        assertEquals("Green Valley Farm", farm.getName());
        assertEquals(Collections.singletonList(field), farm.getFields());
        assertEquals(Collections.singletonList(farmer), farm.getFarmers());
        assertEquals(Collections.singletonList(building), farm.getBuildings());
        assertEquals(Collections.singletonList(equipment), farm.getEquipments());
        assertEquals(Collections.singletonList(animal), farm.getAnimals());
    }

    @Test
    void testEmptyFarmInitialization() {
        FarmBuilder farmBuilder = new FarmBuilder().setName("Empty Farm");

        Farm farm = farmBuilder.build();

        assertEquals("Empty Farm", farm.getName());
        assertTrue(farm.getFields().isEmpty());
        assertTrue(farm.getFarmers().isEmpty());
        assertTrue(farm.getBuildings().isEmpty());
        assertTrue(farm.getEquipments().isEmpty());
        assertTrue(farm.getAnimals().isEmpty());
    }
}
