package cz.cvut.omo.model.build;

public class Greenhouse extends Building{
    public Greenhouse(String name, int capacity) {
        super(name, 50, BuildingType.GREENHOUSE, capacity);
    }

    @Override
    public void performFunction() {
        System.out.println(getType() + " " + getName() + " is used for growing plants.");
    }
}
