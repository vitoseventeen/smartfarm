package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.factory.ProductFactory;
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

        String name = jsonObject.get("name").getAsString();
        double price = jsonObject.get("price").getAsDouble();
        int weight = jsonObject.get("weight").getAsInt();

        return new ProductFactory().createProduct(productTypeStr,name, price, weight);
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


}