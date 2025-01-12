package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.animal.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalFactoryTest {

    @Test
    void testCreateRegisteredAnimal() {
        AnimalFactory animalFactory = new AnimalFactory();

        // Test creation of a cow
        Animal cow = animalFactory.create("cow");
        assertNotNull(cow, "Cow should not be null");
        assertTrue(cow instanceof Cow, "Created animal should be of type Cow");

        // Test creation of a chicken
        Animal chicken = animalFactory.create("chicken");
        assertNotNull(chicken, "Chicken should not be null");
        assertTrue(chicken instanceof Chicken, "Created animal should be of type Chicken");

        // Test creation of a sheep
        Animal sheep = animalFactory.create("sheep");
        assertNotNull(sheep, "Sheep should not be null");
        assertTrue(sheep instanceof Sheep, "Created animal should be of type Sheep");

        // Test creation of a pig
        Animal pig = animalFactory.create("pig");
        assertNotNull(pig, "Pig should not be null");
        assertTrue(pig instanceof Pig, "Created animal should be of type Pig");
    }

    @Test
    void testCreateUnknownAnimal() {
        AnimalFactory animalFactory = new AnimalFactory();

        // Test creation of an unknown animal type
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            animalFactory.create("dragon");
        });

        String expectedMessage = "Unknown type: dragon";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Exception message should match");
    }
}
