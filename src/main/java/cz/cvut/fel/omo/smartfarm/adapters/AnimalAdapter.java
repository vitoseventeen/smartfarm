package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;

import java.lang.reflect.Type;

public class AnimalAdapter extends AAdapter<Animal>{
    @Override
    public Animal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        try {
            JsonObject jsonObject = json.getAsJsonObject();
            String type = jsonObject.get("type").getAsString();
            return AnimalFactory.createAnimal(type);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }

    }

    @Override
    public JsonElement serialize(Animal src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("type", src.getType());
        jsonObject.addProperty("takesPlaces", src.getTakesPlaces());
        jsonObject.addProperty("dailyFoodIntake", src.getDailyFoodIntake());

        return jsonObject;
    }


}
