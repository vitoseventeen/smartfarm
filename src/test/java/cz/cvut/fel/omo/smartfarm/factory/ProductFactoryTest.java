package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.products.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void testCreateDefaultProduct() {
        ProductFactory productFactory = new ProductFactory();

        // Test creation of default Egg
        Product egg = productFactory.create("egg");
        assertNotNull(egg, "Egg should not be null");
        assertTrue(egg instanceof Egg, "Created product should be of type Egg");
        assertEquals("Default Egg", egg.getName());
        assertEquals(5.0, egg.getPrice());
        assertEquals(1, egg.getWeight());

        // Test creation of default Meat
        Product meat = productFactory.create("meat");
        assertNotNull(meat, "Meat should not be null");
        assertTrue(meat instanceof Meat, "Created product should be of type Meat");
        assertEquals("Default Meat", meat.getName());
        assertEquals(50.0, meat.getPrice());
        assertEquals(1, meat.getWeight());

        // Test creation of default Wool
        Product wool = productFactory.create("wool");
        assertNotNull(wool, "Wool should not be null");
        assertTrue(wool instanceof Wool, "Created product should be of type Wool");
        assertEquals("Default Wool", wool.getName());
        assertEquals(20.0, wool.getPrice());
        assertEquals(1, wool.getWeight());

        // Test creation of default Milk
        Product milk = productFactory.create("milk");
        assertNotNull(milk, "Milk should not be null");
        assertTrue(milk instanceof Milk, "Created product should be of type Milk");
        assertEquals("Default Milk", milk.getName());
        assertEquals(10.0, milk.getPrice());
        assertEquals(1, milk.getWeight());
    }

    @Test
    void testCreateCustomProduct() {
        ProductFactory productFactory = new ProductFactory();

        // Test creation of a custom Egg
        Product customEgg = productFactory.createProduct("egg", "Organic Egg", 7.0, 2);
        assertNotNull(customEgg, "Custom Egg should not be null");
        assertTrue(customEgg instanceof Egg, "Created product should be of type Egg");
        assertEquals("Organic Egg", customEgg.getName());
        assertEquals(7.0, customEgg.getPrice());
        assertEquals(2, customEgg.getWeight());

        // Test creation of a custom Meat
        Product customMeat = productFactory.createProduct("meat", "Premium Beef", 100.0, 5);
        assertNotNull(customMeat, "Custom Meat should not be null");
        assertTrue(customMeat instanceof Meat, "Created product should be of type Meat");
        assertEquals("Premium Beef", customMeat.getName());
        assertEquals(100.0, customMeat.getPrice());
        assertEquals(5, customMeat.getWeight());
    }

    @Test
    void testCreateUnknownProduct() {
        ProductFactory productFactory = new ProductFactory();

        // Test creation of an unknown product type
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productFactory.create("unknown");
        });

        String expectedMessage = "Unknown type: unknown";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Exception message should match");
    }
}
