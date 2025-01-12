package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Represents a Workshop within the smart farm system.
 * Workshops are specialized facilities used for crafting goods, repairing equipment, and handling various maintenance tasks.
 */
public class Workshop extends Building<Workshop> {

    /**
     * Default constructor that initializes a Workshop with the WORKSHOP type from BuildingType.
     * This sets up the workshop for general crafting and repair operations.
     */
    public Workshop() {
        super(BuildingType.WORKSHOP);
    }

    /**
     * Constructs a Workshop with a specific name and capacity.
     *
     * @param name The name of the workshop, typically used for identification and organizing work areas.
     * @param capacity The maximum number of tasks or projects that can be handled simultaneously.
     */
    public Workshop(String name, int capacity) {
        super(name, BuildingType.WORKSHOP, capacity);
    }

    /**
     * Creates a copy of this Workshop with a new name and specified capacity.
     * Useful for expanding the farm's capabilities with consistent workshop settings.
     *
     * @param name The new name for the copied workshop.
     * @param capacity The capacity of the copied workshop.
     * @return A new instance of Workshop with the specified name and capacity.
     */
    @Override
    protected Workshop createCopy(String name, int capacity) {
        return new Workshop(name, capacity);
    }

    /**
     * Performs the primary function of the workshop, which is crafting goods.
     * This method logs the operational use of the workshop, highlighting its role in the farm's production activities.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for crafting goods.");
    }
}
