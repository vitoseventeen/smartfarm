package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.build.*;


public class BuildingFactory extends BaseFactory<Building> {

    public BuildingFactory() {

        register(BuildingType.BARN.toString(), Barn::new);
        register(BuildingType.GREENHOUSE.toString(), Greenhouse::new);
        register(BuildingType.HOUSE.toString(), House::new);
        register(BuildingType.STABLE.toString(), Stable::new);
        register(BuildingType.WAREHOUSE.toString(), Warehouse::new);
        register(BuildingType.WORKSHOP.toString(), Workshop::new);

    }

    public Building createBuilding(String type, String name, int capacity) {
        Building product = super.create(type);
        return product.copyWith(name, capacity);
    }

    @Override
    public Building create(String type) {
        System.out.println("Creating building of type: " + type);
        return super.create(type);
    }
}
