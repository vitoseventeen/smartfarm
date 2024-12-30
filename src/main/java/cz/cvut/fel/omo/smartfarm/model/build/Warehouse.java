package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Warehouse extends Building {
    public Warehouse(String name, int capacity) {
        super(name, 200, BuildingType.WAREHOUSE, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for storing goods.");
    }
}
