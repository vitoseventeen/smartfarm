package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

import java.lang.reflect.Type;

/**
 * This abstract class provides a generic implementation for serializing and deserializing objects using Gson.
 * It implements both the JsonSerializer and JsonDeserializer interfaces for the specified type T.
 * It provides functionality for serializing the object's class name and deserializing it back to an instance of the object using reflection.
 *
 * @param <T> The type of object to be serialized and deserialized.
 */
public abstract class AAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    /**
     * Serializes the object of type T into a JSON element.
     * This method serializes the class name of the object as a string.
     *
     * @param state       The object to serialize.
     * @param typeOfSrc   The type of the object to serialize.
     * @param context     The serialization context.
     * @return A JSON element containing the class name of the object.
     */
    @Override
    public JsonElement serialize(T state, Type typeOfSrc, JsonSerializationContext context) {
        // Serialize the simple class name of the object
        return new JsonPrimitive(state.getClass().getSimpleName());
    }

    /**
     * Deserializes a JSON element into an object of type T.
     * This method extracts the class name from the JSON and uses reflection to create an instance of the class.
     *
     * @param json         The JSON element to deserialize.
     * @param typeOfT      The type of the object to deserialize into.
     * @param context      The deserialization context.
     * @return An instance of the object of type T.
     * @throws JsonParseException If the class name cannot be resolved or instantiation fails.
     */
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String className = json.getAsString();
        try {
            // Get the full class name from the type of the target class
            String fullClassName = typeOfT.getTypeName();

            // Extract the package name from the full class name
            String packageName = fullClassName.substring(0, fullClassName.lastIndexOf('.'));

            // Update the class name by appending the package name
            String updatedClassName = packageName + "." + className;

            // Log the updated class name for debugging
            AppLogger.getInstance().logInfo("Updated class name: " + updatedClassName);

            // Load the class using reflection
            Class<?> clazz = Class.forName(updatedClassName);

            // Create a new instance of the class using the no-argument constructor
            return (T) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // Log an error if the class name cannot be resolved or instantiation fails
            AppLogger.getInstance().logError("Unknown state: " + className);
            throw new JsonParseException("Unknown state: " + className, e);
        }
    }
}
