package cz.cvut.omo.model.build;

public class Workshop extends Building {
    public Workshop(String name, int capacity) {
        super(name, 100, BuildingType.WORKSHOP, capacity);
    }

    @Override
    public void performFunction() {
        System.out.println(getType() + " " + getName() + " is used for crafting goods.");
    }
}
