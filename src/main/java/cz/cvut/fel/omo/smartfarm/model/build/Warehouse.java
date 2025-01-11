package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Warehouse extends Building<Warehouse> {
    public Warehouse() {
        super(BuildingType.WAREHOUSE);
    }

    public Warehouse(String name, int capacity) {
        super(name, BuildingType.WAREHOUSE, capacity);
    }

    @Override
    protected Warehouse createCopy(String name, int capacity) {
        return new Warehouse(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for storing goods.");
    }
}
