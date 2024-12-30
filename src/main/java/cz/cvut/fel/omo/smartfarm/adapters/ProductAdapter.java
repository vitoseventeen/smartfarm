package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.model.products.*;

import java.lang.reflect.Type;

public class ProductAdapter extends AAdapter<Product> {

    @Override
    public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject;

        if (json.isJsonObject()) {
            jsonObject = json.getAsJsonObject();
        } else if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
            String productTypeStr = json.getAsString();
            jsonObject = new JsonObject();
            jsonObject.addProperty("productType", productTypeStr);
        } else {
            throw new JsonParseException("Unexpected JSON format for product.");
        }

        String productTypeStr = jsonObject.get("productType").getAsString();
        ProductType productType = ProductType.valueOf(productTypeStr.toUpperCase());

        return createProductByType(productType, jsonObject);
    }

    @Override
    public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("productType", src.getProductType().name());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("price", src.getPrice());
        jsonObject.addProperty("weight", src.getWeight());

        return jsonObject;
    }

    private Product createProductByType(ProductType productType, JsonObject jsonObject) {
        String name = jsonObject.get("name").getAsString();
        double price = jsonObject.get("price").getAsDouble();
        int weight = jsonObject.get("weight").getAsInt();

        return switch (productType) {
            case MILK -> new Milk(name, price, weight);
            case EGG -> new Egg(name, price, weight);
            case MEAT -> new Meat(name, price, weight);
            case WOOL -> new Wool(name, price, weight);
            default -> throw new JsonParseException("Unknown product type: " + productType);
        };
    }
}