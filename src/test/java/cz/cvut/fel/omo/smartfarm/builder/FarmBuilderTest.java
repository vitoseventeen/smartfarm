package cz.cvut.fel.omo.smartfarm.builder;

import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FarmBuilderTest {

    @Test
    void testBuildFarmWithAllComponents() {
        Field field = mock(Field.class);
        Farmer farmer = mock(Farmer.class);
        Building building = mock(Building.class);
        Equipment equipment = mock(Equipment.class);
        Animal animal = mock(Animal.class);
        Product product = mock(Product.class);

        FarmBuilder builder = new FarmBuilder()
                .setName("My Farm")
                .addField(field)
                .addFarmer(farmer)
                .addBuilding(building)
                .addEquipment(equipment)
                .addAnimal(animal)
                .addProduct(product);

        Farm farm = builder.build();

        assertEquals("My Farm", builder.name);
        assertEquals(1, builder.fields.size());
        assertEquals(1, builder.farmers.size());
        assertEquals(1, builder.buildings.size());
        assertEquals(1, builder.equipments.size());
        assertEquals(1, builder.animals.size());
        assertEquals(1, builder.products.size());
    }

    @Test
    void testAddMultipleFields() {
        Field field1 = mock(Field.class);
        Field field2 = mock(Field.class);
        List<Field> fields = List.of(field1, field2);

        FarmBuilder builder = new FarmBuilder().addFields(fields);

        assertEquals(2, builder.fields.size());
        assertTrue(builder.fields.contains(field1));
        assertTrue(builder.fields.contains(field2));
    }

    @Test
    void testGetProductPrice() {
        Product product1 = mock(Product.class);
        when(product1.getPrice()).thenReturn(10.0);
        Product product2 = mock(Product.class);
        when(product2.getPrice()).thenReturn(15.0);

        FarmBuilder builder = new FarmBuilder().addProduct(product1).addProduct(product2);

        double totalPrice = builder.getProductPrice();
        assertEquals(25.0, totalPrice, 0.001);
    }

    @Test
    void testEmptyFarm() {
        FarmBuilder builder = new FarmBuilder();
        Farm farm = builder.build();

        assertTrue(builder.fields.isEmpty());
        assertTrue(builder.farmers.isEmpty());
        assertTrue(builder.buildings.isEmpty());
        assertTrue(builder.equipments.isEmpty());
        assertTrue(builder.animals.isEmpty());
        assertTrue(builder.products.isEmpty());
    }
}
