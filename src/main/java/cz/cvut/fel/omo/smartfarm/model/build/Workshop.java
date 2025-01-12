package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Workshop extends Building<Workshop> {
    public Workshop() {
        super(BuildingType.WORKSHOP);
    }

    public Workshop(String name, int capacity) {
        super(name, BuildingType.WORKSHOP, capacity);
    }

    @Override
    protected Workshop createCopy(String name, int capacity) {
        return new Workshop(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for crafting goods.");
    }
}
