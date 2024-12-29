package cz.cvut.fel.omo.smartfarm.model.build;

public class Barn extends Building {
    public Barn(String name, int capacity) {
        super(name, 50, BuildingType.BARN, capacity);
    }

    @Override
    public void performFunction() {
        System.out.println(getType().getDisplayName() + " " + getName() + " is used for keeping hay.");
    }
}
