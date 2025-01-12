package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Stable within the smart farm system.
 * Stables are primarily used to house animals, providing shelter and a controlled environment for them.
 */
public class Stable extends Building<Stable> {

    private List<Animal> animals = new ArrayList<>();

    /**
     * Default constructor for a Stable, initializing it with the STABLE building type.
     */
    public Stable() {
        super(BuildingType.STABLE);
    }

    /**
     * Constructs a Stable with a specific name and capacity.
     *
     * @param name The name of the stable, typically used for identification.
     * @param capacity The maximum number of animals the stable can accommodate.
     */
    public Stable(String name, int capacity) {
        super(name, BuildingType.STABLE, capacity);
        setCurrentUsage(0);
    }

    /**
     * Sets the list of animals housed in the stable and updates the current usage accordingly.
     *
     * @param animals A list of animals to be housed in the stable.
     */
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
        setCurrentUsage(animals.size());
    }

    /**
     * Creates a copy of this Stable with a new name and specified capacity.
     * Useful for expanding the farm's facilities with consistent stable settings.
     *
     * @param name The new name for the copied stable.
     * @param capacity The capacity of the copied stable.
     * @return A new instance of Stable with the specified name and capacity.
     */
    @Override
    protected Stable createCopy(String name, int capacity) {
        return new Stable(name, capacity);
    }

    /**
     * Performs the primary function of the stable, which is to provide shelter for animals.
     * This method logs the operational use of the stable in the farm system.
     */
    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for keeping animals.");
    }

    /**
     * Returns the list of animals currently housed in the stable.
     *
     * @return A list of animals.
     */
    public List<Animal> getAnimals() {
        return animals;
    }
}
