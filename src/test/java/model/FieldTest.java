package model;

import cz.cvut.omo.model.field.Field;
import cz.cvut.omo.model.field.FieldStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {
    @Test
    public void testFieldInitialization() {
        Field field = new Field("Corn", 100, FieldStatus.FREE);
        assertEquals("Corn", field.getCropType());
        assertEquals(100, field.getFieldSize());
        assertEquals(FieldStatus.FREE, field.getStatus());
    }

    @Test
    public void testFieldSetCropType() {
        Field field = new Field("Corn", 100, FieldStatus.FREE);
        field.setCropType("Wheat");
        assertEquals("Wheat", field.getCropType());
    }

    @Test
    public void testFieldSetFieldSize() {
        Field field = new Field("Corn", 100, FieldStatus.FREE);
        field.setFieldSize(200);
        assertEquals(200, field.getFieldSize());
    }

    @Test
    public void testFieldSetFieldSizeNegative() {
        Field field = new Field("Corn", 100, FieldStatus.FREE);
        field.setFieldSize(-200);
        assertEquals(100, field.getFieldSize());
    }

    @Test
    public void testFieldStatus() {
        Field field = new Field("Corn", 100, FieldStatus.FREE);
        assertEquals(FieldStatus.FREE, field.getStatus());
        field.setStatus(FieldStatus.PLANTED);
        assertEquals(FieldStatus.PLANTED, field.getStatus());
        field.setStatus(FieldStatus.READY_TO_HARVEST);
        assertEquals(FieldStatus.READY_TO_HARVEST, field.getStatus());
        field.setStatus(FieldStatus.PESTICIDE_APPLIED);
        assertEquals(FieldStatus.PESTICIDE_APPLIED, field.getStatus());
    }
}
