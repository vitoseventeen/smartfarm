package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Represents a Warehouse within the smart farm system.
 * Warehouses are used primarily for storing goods, farm products, and equipment.
 */
public class Warehouse extends Building<Warehouse> {

    /**
     * Default constructor that initializes a Warehouse with standard settings
     * using the predefined WAREHOUSE type from BuildingType.
     */
    public Warehouse() {
        super(BuildingType.WAREHOUSE);
    }

    /**
     * Constructs a Warehouse with a specific name and capacity.
     *
     * @param name The name of the warehouse, typically used for identification.
     * @param capacity The maximum number of units (e.g., products or equipment) the warehouse can store.
     */
    public Warehouse(String name, int capacity) {
        super(name, BuildingType.WAREHOUSE, capacity);
    }

    /**
     * Creates a copy of this Warehouse with a new name and specified capacity.
     * Useful for duplicating warehouse settings to expand storage capacity at other locations.
     *
     * @param name The new name for the copied warehouse.
     * @param capacity The capacity of the copied warehouse.
     * @return A new instance of Warehouse with the specified name and capacity.
     */
    @Override
    protected Warehouse createCopy(String name, int capacity) {
        return new Warehouse(name, capacity);
    }

    /**
     * Performs the primary function of the warehouse, which is storing goods.
     * This method logs the operational use of the warehouse.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for storing goods.");
    }
}
