package model;

import cz.cvut.omo.model.build.Barn;
import cz.cvut.omo.model.build.BuildingType;
import cz.cvut.omo.model.build.Stable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

}
