package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

import java.lang.reflect.Type;


public abstract class AAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public JsonElement serialize(T state, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(state.getClass().getSimpleName());
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String className = json.getAsString();
        try {

            String fullClassName = typeOfT.getTypeName();

            String packageName = fullClassName.substring(0, fullClassName.lastIndexOf('.'));

            String updatedClassName = packageName + "." + className;

            AppLogger.getInstance().logInfo("Updated class name: " + updatedClassName);

            Class<?> clazz = Class.forName(updatedClassName);

            return (T) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            AppLogger.getInstance().logError("Unknown state: " + className);
            throw new JsonParseException("Unknown state: " + className, e);
        }
    }

}



