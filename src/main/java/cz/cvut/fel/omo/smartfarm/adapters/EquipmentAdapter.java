package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;

import java.lang.reflect.Type;

/**
 * This class is an adapter for serializing and deserializing Equipment objects using Gson.
 * It handles the conversion between JSON and Equipment instances, supporting different types of equipment such as Machine and Tool.
 */
public class EquipmentAdapter extends AAdapter<Equipment> {

    /**
     * Deserializes a JSON element into an Equipment object.
     * Based on the "type" field in the JSON, it decides whether to deserialize into a Machine or Tool.
     *
     * @param json         The JSON element to deserialize.
     * @param typeOfT      The type of the object to deserialize into (Equipment).
     * @param context      The deserialization context.
     * @return An Equipment object (either Machine or Tool) created from the JSON data.
     * @throws JsonParseException If the JSON format is invalid or the equipment type is unknown.
     */
    @Override
    public Equipment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();

        return switch (type) {
            case "Machine" -> context.deserialize(json, Machine.class);
            case "Tool" -> context.deserialize(json, Tool.class);
            default -> throw new JsonParseException("Unknown equipment type: " + type);
        };
    }

    /**
     * Serializes an Equipment object into a JSON element.
     * It serializes the type of equipment (Machine or Tool) and other specific fields based on the equipment type.
     *
     * @param src           The Equipment object to serialize.
     * @param typeOfSrc     The type of the object to serialize (Equipment).
     * @param context       The serialization context.
     * @return A JSON representation of the Equipment object.
     */
    @Override
    public JsonElement serialize(Equipment src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName()); // Serialize the equipment type

        // Serialize additional fields based on the specific equipment type
        if (src instanceof Machine) {
            Machine machine = (Machine) src;
            jsonObject.addProperty("name", machine.getName());
            jsonObject.addProperty("currentState", machine.getState().toString());
            jsonObject.addProperty("fuelLevel", machine.getFuelLevel());
        } else if (src instanceof Tool) {
            Tool tool = (Tool) src;
            jsonObject.addProperty("name", tool.getName());
            jsonObject.addProperty("currentState", tool.getState().toString());
            jsonObject.addProperty("usageType", tool.getUsageType());
        }

        return jsonObject;
    }
}
