package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Represents a Greenhouse within the smart farm system.
 * Specialized for growing plants under controlled conditions, this building type
 * uses advanced climate control to optimize plant growth.
 */
public class Greenhouse extends Building<Greenhouse> {

    /**
     * Default constructor that initializes a Greenhouse with standard settings
     * using the predefined GREENHOUSE type from BuildingType.
     */
    public Greenhouse() {
        super(BuildingType.GREENHOUSE);
    }

    /**
     * Constructs a Greenhouse with a specific name and capacity.
     *
     * @param name The name of the greenhouse, typically used for identification.
     * @param capacity The maximum number of plant units or products the greenhouse can accommodate.
     */
    public Greenhouse(String name, int capacity) {
        super(name, BuildingType.GREENHOUSE, capacity);
    }

    /**
     * Creates a copy of this Greenhouse with a new name and specified capacity.
     * Useful for replicating greenhouse settings while adjusting for different operational needs.
     *
     * @param name The new name for the copied greenhouse.
     * @param capacity The capacity of the copied greenhouse.
     * @return A new instance of Greenhouse with the specified name and capacity.
     */
    @Override
    protected Greenhouse createCopy(String name, int capacity) {
        return new Greenhouse(name, capacity);
    }

    /**
     * Performs the primary function of the greenhouse, which is growing plants.
     * This method logs the operation, highlighting the use of the greenhouse in the smart farm system.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for growing plants.");
    }
}
