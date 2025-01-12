package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a House in the smart farm system.
 * Houses are primarily used to accommodate farmers, providing living quarters within the farm.
 */
public class House extends Building<House> {
    private List<Farmer> farmers = new ArrayList<>();

    /**
     * Default constructor for a House, initializing it with the HOUSE building type.
     */
    public House() {
        super(BuildingType.HOUSE);
    }

    /**
     * Constructs a House with a specific name and capacity.
     *
     * @param name The name of the house, typically used for identification.
     * @param capacity The maximum number of farmers the house can accommodate.
     */
    public House(String name, int capacity) {
        super(name, BuildingType.HOUSE, capacity);
    }

    /**
     * Returns the current number of farmers living in the house.
     *
     * @return The current number of occupants.
     */
    public int getCurrentUsage() {
        return farmers.size();
    }

    /**
     * Returns the list of farmers residing in the house.
     *
     * @return A list of farmers.
     */
    public List<Farmer> getFarmers() {
        return farmers;
    }

    /**
     * Sets the list of farmers living in the house and updates the current usage accordingly.
     *
     * @param farmers A list of farmers to be set as residents of the house.
     */
    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
        setCurrentUsage(farmers.size());
    }

    /**
     * Creates a copy of this House with a new name and specified capacity.
     * Useful for duplicating house settings for new building projects.
     *
     * @param name The new name for the copied house.
     * @param capacity The capacity of the copied house.
     * @return A new instance of House with the specified name and capacity.
     */
    @Override
    protected House createCopy(String name, int capacity) {
        return new House(name, capacity);
    }

    /**
     * Performs the primary function of the house, which is providing living quarters for farmers.
     * This method logs the operational use of the house.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for living.");
    }
}
