package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

public enum EventType {

    // Equipment-related events
    REFUEL,
    REPAIR,
    TURN_ON,
    TURN_OFF,
    PERFORM_ACTION,
    BREAK_DOWN,


    // Field-related events
    PLANT_CROPS,
    HARVEST_CROPS,
    APPLY_PESTICIDE,

    // Farmer-related events
    FARMER_SLEEP,
    FARMER_REST,
    FARMER_WORK,

    // Animal-related events
//    COW_PRODUCE,
//    PIG_PRODUCE,
//    CHICKEN_PRODUCE,
//    SHEEP_PRODUCE
}
