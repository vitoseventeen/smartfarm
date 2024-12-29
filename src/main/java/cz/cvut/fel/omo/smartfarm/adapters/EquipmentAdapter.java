package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;

import java.lang.reflect.Type;

public class EquipmentAdapter extends  AAdapter<Equipment>{

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

    @Override
    public JsonElement serialize(Equipment src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName()); // Сериализуем тип

        // Дополнительно сериализуем другие поля объекта
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

