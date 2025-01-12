package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.factory.AnimalFactory;

import java.lang.reflect.Type;

/**
 * This class is an adapter for serializing and deserializing Animal objects using Gson.
 * It handles the conversion between JSON and Animal instances, supporting various animal types such as Cow, Chicken, etc.
 */
public class AnimalAdapter extends AAdapter<Animal> {

    /**
     * Deserializes a JSON element into an Animal object.
     * The method extracts the animal type from the JSON and creates the corresponding Animal instance using the AnimalFactory.
     *
     * @param json         The JSON element to deserialize.
     * @param typeOfT      The type of the object to deserialize into (Animal).
     * @param context      The deserialization context.
     * @return An Animal object created from the JSON data.
     * @throws JsonParseException If the JSON format is invalid or there is an error creating the Animal.
     */
    @Override
    public Animal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        try {
            JsonObject jsonObject = json.getAsJsonObject();
            String type = jsonObject.get("type").getAsString();

            // Create the appropriate animal using the AnimalFactory
            return (new AnimalFactory()).create(type);
        } catch (Exception e) {
            // Catch any exception during deserialization and throw a JsonParseException
            throw new JsonParseException(e);
        }
    }

    /**
     * Serializes an Animal object into a JSON element.
     * The method converts the animal's type, takesPlaces, and dailyFoodIntake into a JSON object.
     *
     * @param src           The Animal object to serialize.
     * @param typeOfSrc     The type of the object to serialize (Animal).
     * @param context       The serialization context.
     * @return A JSON representation of the Animal object.
     */
    @Override
    public JsonElement serialize(Animal src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        // Serialize the animal's properties into the JSON object
        jsonObject.addProperty("type", src.getType());
        jsonObject.addProperty("takesPlaces", src.getTakesPlaces());
        jsonObject.addProperty("dailyFoodIntake", src.getDailyFoodIntake());

        return jsonObject;
    }
}
