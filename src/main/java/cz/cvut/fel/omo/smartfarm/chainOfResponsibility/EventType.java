package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

/**
 * Enum defining different types of events that can occur in a smart farm environment.
 * These events are categorized into different sections based on their relevance to equipment, fields, farmers, or animals.
 */
public enum EventType {

    // Equipment-related events
    /** Event indicating equipment needs refueling. */
    REFUEL,
    /** Event indicating equipment needs repair. */
    REPAIR,
    /** Event indicating equipment should be turned on. */
    TURN_ON,
    /** Event indicating equipment should be turned off. */
    TURN_OFF,
    /** Event indicating equipment should perform its designated action. */
    PERFORM_ACTION,
    /** Event indicating equipment has broken down. */
    BREAK_DOWN,


    // Field-related events
    /** Event indicating that crops should be planted. */
    PLANT_CROPS,
    /** Event indicating that crops are ready to be harvested. */
    HARVEST_CROPS,
    /** Event indicating that pesticide needs to be applied. */
    APPLY_PESTICIDE,

    // Farmer-related events
    /** Event indicating the farmer is going to sleep. */
    FARMER_SLEEP,
    /** Event indicating the farmer is taking a rest. */
    FARMER_REST,
    /** Event indicating the farmer is working. */
    FARMER_WORK,

}
