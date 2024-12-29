package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.build.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class BuildingAdapter extends AAdapter<Building> {
    @Override
    public Building deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String type = json.getAsJsonObject().get("type").getAsString();
        BuildingType buildingType = BuildingType.valueOf(type.toUpperCase());

        String name = json.getAsJsonObject().get("name").getAsString();
        int capacity = json.getAsJsonObject().get("capacity").getAsInt();


        return switch (buildingType) {
            case BARN -> new Barn(name, capacity);
            case STABLE -> new Stable(name, capacity, new ArrayList<>());
            case GREENHOUSE -> new Greenhouse(name, capacity);
            case WAREHOUSE -> new Warehouse(name, capacity);
            case HOUSE -> new House(name, capacity, new ArrayList<>());
            case WORKSHOP -> new Workshop(name, capacity);
            default -> throw new JsonParseException("Unknown building type: " + type);
        };
    }

    @Override
    public JsonElement serialize(Building src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName());
        return jsonObject;
    }



}
