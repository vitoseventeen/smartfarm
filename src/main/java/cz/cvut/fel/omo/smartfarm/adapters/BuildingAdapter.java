package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.factory.BuildingFactory;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuildingAdapter extends AAdapter<Building> {

    @Override
    public Building deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Extract the building type and map to the appropriate enum
        String type = jsonObject.has("type") ? jsonObject.get("type").getAsString() : "";
        BuildingType buildingType = BuildingType.valueOf(type.toUpperCase());

        // Extract the common fields with default values if missing
        String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unknown Building";
        int capacity = jsonObject.has("capacity") ? jsonObject.get("capacity").getAsInt() : 0;


        return new BuildingFactory().createBuilding(buildingType.toString(), name, capacity);
    }

    @Override
    public JsonElement serialize(Building src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("type", src.getClass().getSimpleName());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("capacity", src.getCapacity());

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
