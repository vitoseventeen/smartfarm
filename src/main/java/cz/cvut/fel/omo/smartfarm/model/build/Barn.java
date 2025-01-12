package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Represents a Barn in the smart farm system.
 * This class provides specific functionalities for a barn, such as storing hay and sheltering animals.
 */
public class Barn extends Building<Barn> {

    /**
     * Default constructor for creating a Barn with standard attributes.
     * Initializes the barn with a predefined building type specific to barns.
     */
    public Barn() {
        super(BuildingType.BARN);
    }

    /**
     * Constructs a Barn with a specified name and capacity.
     *
     * @param name The name of the barn.
     * @param capacity The capacity of the barn, typically defined as the number of animals or the amount of hay it can store.
     */
    public Barn(String name, int capacity) {
        super(name, BuildingType.BARN, capacity);
    }

    /**
     * Creates a copy of this Barn with a new name and capacity.
     * This method supports the prototype pattern allowing for the creation of new barns with modified properties.
     *
     * @param name The name for the new barn copy.
     * @param capacity The capacity of the new barn copy.
     * @return A new instance of Barn with specified name and capacity.
     */
    @Override
    protected Barn createCopy(String name, int capacity) {
        return new Barn(name, capacity);
    }

    /**
     * Implements the specific function of the barn.
     * Logs the usage of the barn for keeping hay using the application's logging system.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for keeping hay.");
    }
}
