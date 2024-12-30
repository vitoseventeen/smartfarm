package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Greenhouse extends Building{
    public Greenhouse(String name, int capacity) {
        super(name, 50, BuildingType.GREENHOUSE, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for growing plants.");
    }
}
