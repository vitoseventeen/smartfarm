package model;

import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalFactoryTest {

//    @Test
//    public void testChicken() {
//        Animal chicken = AnimalFactory.createAnimal("chicken");
//        assertEquals("Chicken", chicken.getType());
//        assertEquals(1, chicken.getTakesPlaces());
//        assertEquals(2, chicken.getDailyFoodIntake());
//    }
//
//    @Test
//    public void testCow() {
//        Animal cow = AnimalFactory.createAnimal("cow", 10);
//        assertEquals("Cow", cow.getType());
//        assertEquals(4, cow.getTakesPlaces());
//        assertEquals(10, cow.getDailyFoodIntake());
//    }
//
//    @Test
//    public void testPig() {
//        Animal pig = AnimalFactory.createAnimal("Pig", 5);
//        assertEquals("Pig", pig.getType());
//        assertEquals(3, pig.getTakesPlaces());
//        assertEquals(5, pig.getDailyFoodIntake());
//    }

    @Test
    public void testInvalidAnimal() {
        try {
            Animal invalidAnimal = AnimalFactory.createAnimal("dragon");
        } catch (IllegalArgumentException e) {
            assertEquals("Unknown animal type: dragon", e.getMessage());
        }
    }
}
