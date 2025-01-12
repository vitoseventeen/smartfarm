package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.build.*;

/**
 * This class is a factory for creating Building objects.
 * It extends the BaseFactory and registers the supported building types,
 * such as barn, greenhouse, house, stable, warehouse, and workshop.
 * It provides functionality to create buildings of a specified type with additional properties.
 */
public class BuildingFactory extends BaseFactory<Building> {

    /**
     * Constructor that registers the available building types with their corresponding creation methods.
     * The factory supports creating various types of buildings such as Barn, Greenhouse, House, etc.
     */
    public BuildingFactory() {
        // Register building types with their respective creation methods
        register(BuildingType.BARN.toString(), Barn::new);
        register(BuildingType.GREENHOUSE.toString(), Greenhouse::new);
        register(BuildingType.HOUSE.toString(), House::new);
        register(BuildingType.STABLE.toString(), Stable::new);
        register(BuildingType.WAREHOUSE.toString(), Warehouse::new);
        register(BuildingType.WORKSHOP.toString(), Workshop::new);
    }

    /**
     * Creates a Building object of the specified type with a name and capacity.
     * This method uses the create method from the BaseFactory to instantiate the correct Building subclass,
     * and then calls the copyWith method to set the name and capacity.
     *
     * @param type     The type of building to create (e.g., "barn", "greenhouse", etc.).
     * @param name     The name of the building.
     * @param capacity The capacity of the building.
     * @return A new Building object with the specified type, name, and capacity.
     */
    public Building createBuilding(String type, String name, int capacity) {
        // Create the building object based on the specified type
        Building product = super.create(type);

        // Set the name and capacity of the created building
        return product.copyWith(name, capacity);
    }

    /**
     * Creates a Building object of the specified type.
     * This method logs the type of building being created and delegates to the parent class to create the building.
     *
     * @param type The type of building to create.
     * @return A new Building object of the specified type.
     */
    @Override
    public Building create(String type) {
        // Log the type of building being created
        System.out.println("Creating building of type: " + type);

        // Delegate the creation to the parent class
        return super.create(type);
    }
}
