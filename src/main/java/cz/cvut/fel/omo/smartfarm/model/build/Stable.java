package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;

import java.util.List;
import java.util.logging.Logger;

public class Stable extends Building {

    private List<Animal> animals;

    public Stable(String name, int capacity, List<Animal> animals) {
        super(name, 40, BuildingType.STABLE, capacity);
        this.animals = animals;
        setCurrentUsage(animals.size());
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for keeping animals.");
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
