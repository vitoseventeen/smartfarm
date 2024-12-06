package cz.cvut.omo.model.build;


import cz.cvut.omo.model.animal.Animal;
import cz.cvut.omo.model.farmer.Farmer;

import java.util.List;

public class House extends Building {
    private List<Farmer> farmers;

    public House(String name, int area, List<Farmer> farmers) {
        super(name, area, BuildingType.HOUSE, farmers.size());
        this.farmers = farmers;
    }

    public int getCurrentUsage() {
        return farmers.size();
    }


    @Override
    public void performFunction() {
        System.out.println(getType() + " " + getName() + "is used for living.");
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }
}
