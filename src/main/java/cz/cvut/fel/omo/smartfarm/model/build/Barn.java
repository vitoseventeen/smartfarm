package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Barn extends Building {
    public Barn(String name, int capacity) {
        super(name, 50, BuildingType.BARN, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for keeping hay.");
    }
}
