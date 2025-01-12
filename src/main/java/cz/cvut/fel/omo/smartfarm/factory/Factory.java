package cz.cvut.fel.omo.smartfarm.factory;

/**
 * This interface defines a generic factory for creating objects of type T.
 * It provides a method to create an instance of T based on the specified type.
 *
 * @param <T> The type of object that the factory will create.
 */
public interface Factory<T> {

    /**
     * Creates an object of the specified type.
     * The type corresponds to a specific implementation or subclass of T.
     *
     * @param type The type of object to create (e.g., "animal", "building", etc.).
     * @return A new instance of the specified type.
     */
    T create(String type);
}
