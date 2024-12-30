package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Workshop extends Building {
    public Workshop(String name, int capacity) {
        super(name, 100, BuildingType.WORKSHOP, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for crafting goods.");
    }
}
