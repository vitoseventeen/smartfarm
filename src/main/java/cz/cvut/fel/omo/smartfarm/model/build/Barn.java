package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class Barn extends Building<Barn> {

    public Barn() {
        super(BuildingType.BARN);
    }

    public Barn(String name, int capacity) {
        super(name, BuildingType.BARN, capacity);
    }

    @Override
    protected Barn createCopy(String name, int capacity) {
        return new Barn(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType().getDisplayName() + " " + getName() + " is used for keeping hay.");
    }
}
