package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.factory.BuildingFactory;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an adapter for serializing and deserializing Building objects using Gson.
 * It handles the conversion between JSON and Building instances, supporting different types of buildings such as Stable and House.
 */
public class BuildingAdapter extends AAdapter<Building> {

    /**
     * Deserializes a JSON element into a Building object.
     * The method extracts the building type, name, and capacity from the JSON and creates the appropriate Building instance.
     *
     * @param json         The JSON element to deserialize.
     * @param typeOfT      The type of the object to deserialize into (Building).
     * @param context      The deserialization context.
     * @return A Building object created from the JSON data.
     * @throws JsonParseException If the JSON format is invalid or the building type is unknown.
     */
    @Override
    public Building deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Extract the building type and map to the appropriate enum
        String type = jsonObject.has("type") ? jsonObject.get("type").getAsString() : "";
        BuildingType buildingType = BuildingType.valueOf(type.toUpperCase());

        // Extract the common fields with default values if missing
        String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unknown Building";
        int capacity = jsonObject.has("capacity") ? jsonObject.get("capacity").getAsInt() : 0;

        // Create the building using the BuildingFactory and return it
        return new BuildingFactory().createBuilding(buildingType.toString(), name, capacity);
    }

    /**
     * Serializes a Building object into a JSON element.
     * The method converts the building's type, name, capacity, and additional fields specific to the building type (e.g., animals in Stable, farmers in House) into a JSON object.
     *
     * @param src           The Building object to serialize.
     * @param typeOfSrc     The type of the object to serialize (Building).
     * @param context       The serialization context.
     * @return A JSON representation of the Building object.
     */
    @Override
    public JsonElement serialize(Building src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        // Serialize common fields
        jsonObject.addProperty("type", src.getClass().getSimpleName());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("capacity", src.getCapacity());

        // Serialize additional fields based on the specific building type (Stable or House)
        if (src instanceof Stable) {
            Stable stable = (Stable) src;
            JsonArray animals = new JsonArray();
            for (Animal animal : stable.getAnimals()) {
                JsonObject animalObject = new JsonObject();
                animalObject.addProperty("type", animal.getType().toString());
                animalObject.addProperty("takesPlaces", animal.getTakesPlaces());
                animalObject.addProperty("dailyFoodIntake", animal.getDailyFoodIntake());
                animals.add(animalObject);
            }
            jsonObject.add("animals", animals);
        }

        if (src instanceof House) {
            House house = (House) src;
            JsonArray farmers = new JsonArray();
            for (Farmer farmer : house.getFarmers()) {
                JsonObject farmerObject = new JsonObject();
                farmerObject.addProperty("name", farmer.getName());
                farmerObject.addProperty("age", farmer.getAge());
                farmerObject.addProperty("currentState", farmer.getState().toString());
                farmers.add(farmerObject);
            }
            jsonObject.add("farmers", farmers);
        }

        return jsonObject;
    }
}
