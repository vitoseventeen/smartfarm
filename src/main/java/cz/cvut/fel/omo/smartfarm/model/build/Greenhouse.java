package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Greenhouse extends Building<Greenhouse> {
    public Greenhouse() {
        super(BuildingType.GREENHOUSE);
    }

    public Greenhouse(String name, int capacity) {
        super(name, BuildingType.GREENHOUSE, capacity);
    }

    @Override
    protected Greenhouse createCopy(String name, int capacity) {
        return new Greenhouse(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + " is used for growing plants.");
    }
}
