package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.animal.*;

/**
 * This class is a factory for creating Animal objects.
 * It extends the BaseFactory and registers the supported animal types,
 * such as cow, chicken, sheep, and pig.
 * It provides the functionality to create an animal of a specified type.
 */
public class AnimalFactory extends BaseFactory<Animal> {

    /**
     * Constructor that registers the available animal types with their corresponding creation methods.
     */
    public AnimalFactory() {
        // Register animal types with their respective creation methods
        register("cow", Cow::new);
        register("chicken", Chicken::new);
        register("sheep", Sheep::new);
        register("pig", Pig::new);
    }

    /**
     * Creates an Animal object of the specified type.
     * This method calls the create method from the BaseFactory to instantiate the correct Animal subclass.
     *
     * @param type The type of animal to create (e.g., "cow", "chicken", etc.).
     * @return A new Animal object of the specified type.
     */
    @Override
    public Animal create(String type) {
        // Log the type of animal being created
        System.out.println("Creating animal of type: " + type);

        // Delegate the creation to the parent class
        return super.create(type);
    }
}
