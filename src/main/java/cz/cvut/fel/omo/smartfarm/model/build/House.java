package cz.cvut.fel.omo.smartfarm.model.build;


import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

import java.util.ArrayList;
import java.util.List;

public class House extends Building<House> {
    private List<Farmer> farmers = new ArrayList<>();

    public House() {
        super(BuildingType.HOUSE);
    }

    public House(String name, int capacity) {
        super(name, BuildingType.HOUSE, capacity);
    }

    public int getCurrentUsage() {
        return farmers.size();
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
        setCurrentUsage(farmers.size());
    }

    @Override
    protected House createCopy(String name, int capacity) {
        return new House(name, capacity);
    }

    @Override
    public void performFunction() {
        AppLogger.getInstance().logInfo(getType() + " " + getName() + "is used for living.");
    }
}
