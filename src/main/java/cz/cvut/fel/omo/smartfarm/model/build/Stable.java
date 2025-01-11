package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Stable extends Building<Stable> {

    private List<Animal> animals = new ArrayList<>();


    public Stable() {
        super(BuildingType.STABLE);
    }


    public Stable(String name, int capacity) {
        super(name, BuildingType.STABLE, capacity);
        setCurrentUsage(0);
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
        setCurrentUsage(animals.size());
    }

    @Override
    protected Stable createCopy(String name, int capacity) {
        return new Stable(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for keeping animals.");
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
