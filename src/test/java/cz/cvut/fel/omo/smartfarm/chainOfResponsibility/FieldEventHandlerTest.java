package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;


import cz.cvut.fel.omo.smartfarm.model.field.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;


class FieldEventHandlerTest {

    private Field field;
    private FieldEventHandler fieldEventHandler;

    @BeforeEach
    void setUp() {
        field = mock(Field.class); // Mocking the Field class
        fieldEventHandler = new FieldEventHandler(field);
    }

    @Test
    void testHandleEventPlantCrops() {
        Event plantEvent = new Event(EventType.PLANT_CROPS, "Planting crops");

        // Handle the event
        fieldEventHandler.handleEvent(plantEvent);

        // Verify that plant method was called on the field
        verify(field, times(1)).plant();
    }

    @Test
    void testHandleEventHarvestCrops() {
        Event harvestEvent = new Event(EventType.HARVEST_CROPS, "Harvesting crops");

        // Handle the event
        fieldEventHandler.handleEvent(harvestEvent);

        // Verify that harvest method was called on the field
        verify(field, times(1)).harvest();
    }

    @Test
    void testHandleEventApplyPesticides() {
        Event applyPesticideEvent = new Event(EventType.APPLY_PESTICIDE, "Applying pesticides");

        // Handle the event
        fieldEventHandler.handleEvent(applyPesticideEvent);

        // Verify that applyPesticides method was called on the field
        verify(field, times(1)).applyPesticides();
    }

    @Test
    void testHandleEventUnknownType() {
        Event unknownEvent = new Event(EventType.FARMER_SLEEP, "Farmer going to sleep");

        // Handle the event, should pass to the next handler (if set)
        EventHandler nextHandler = mock(EventHandler.class);
        fieldEventHandler.setNextHandler(nextHandler);

        fieldEventHandler.handleEvent(unknownEvent);

        // Verify that the event was passed to the next handler
        verify(nextHandler, times(1)).handleEvent(unknownEvent);
    }
}
