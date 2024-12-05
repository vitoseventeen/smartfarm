package model;

import cz.cvut.omo.model.animal.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void testChicken() {
        Animal chicken = AnimalFactory.createAnimal("chicken", 2);
        assertEquals("Chicken", chicken.getType());
        assertEquals(1, chicken.getTakesPlaces());
        assertEquals(2, chicken.getDailyFoodIntake());
    }

    @Test
    public void testCow() {
        Animal cow = AnimalFactory.createAnimal("cow", 10);
        assertEquals("Cow", cow.getType());
        assertEquals(4, cow.getTakesPlaces());
        assertEquals(10, cow.getDailyFoodIntake());
    }

    @Test
    public void testHorse() {
        Animal horse = AnimalFactory.createAnimal("Horse", 12);
        assertEquals("Horse", horse.getType());
        assertEquals(5, horse.getTakesPlaces());
        assertEquals(12, horse.getDailyFoodIntake());
    }

    @Test
    public void testPig() {
        Animal pig = AnimalFactory.createAnimal("Pig", 5);
        assertEquals("Pig", pig.getType());
        assertEquals(3, pig.getTakesPlaces());
        assertEquals(5, pig.getDailyFoodIntake());
    }

    @Test
    public void testInvalidAnimal() {
        try {
            Animal invalidAnimal = AnimalFactory.createAnimal("dragon", 100);
        } catch (IllegalArgumentException e) {
            assertEquals("Unknown animal type: dragon", e.getMessage());
        }
    }
}
