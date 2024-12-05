package cz.cvut.omo.model.build;

public class Warehouse extends Building {
    public Warehouse(String name, int capacity) {
        super(name, 200, BuildingType.WAREHOUSE, capacity);
    }

    @Override
    public void performFunction() {
        System.out.println(getType() + " " + getName() + " is used for storing goods.");
    }
}
