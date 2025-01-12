package cz.cvut.fel.omo.smartfarm.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This class is a generic base factory that manages a registry of types and their corresponding suppliers.
 * It allows registering types and creating objects based on their type.
 * This class implements the Factory interface.
 *
 * @param <T> The type of object that the factory will create.
 */
public class BaseFactory<T> implements Factory<T> {

    // A map that stores the registration of types and their corresponding suppliers
    protected final Map<String, Supplier<T>> registry = new HashMap<>();

    /**
     * Registers a type and its corresponding supplier to the factory.
     *
     * @param type     The type of object to be created.
     * @param supplier The supplier that will create the object of the specified type.
     */
    public void register(String type, Supplier<T> supplier) {
        registry.put(type.toLowerCase(), supplier);
    }

    /**
     * Creates an object of the specified type by using the corresponding supplier from the registry.
     * If the type is not found in the registry, an IllegalArgumentException is thrown.
     *
     * @param type The type of object to create (case-insensitive).
     * @return A new instance of the specified type.
     * @throws IllegalArgumentException If the type is not found in the registry.
     */
    @Override
    public T create(String type) {
        // Get the supplier for the specified type
        Supplier<T> supplier = registry.get(type.toLowerCase());

        // If no supplier is found for the type, throw an exception
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }

        // Return a new instance created by the supplier
        return supplier.get();
    }
}
