package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.*;
import cz.cvut.fel.omo.smartfarm.factory.ProductFactory;
import cz.cvut.fel.omo.smartfarm.model.products.*;

import java.lang.reflect.Type;

/**
 * This class is an adapter for serializing and deserializing Product objects using Gson.
 * It handles the conversion between JSON and Product instances, supporting different product types such as Egg, Meat, etc.
 */
public class ProductAdapter extends AAdapter<Product> {

    /**
     * Deserializes a JSON element into a Product object.
     * The method extracts the product type, name, price, and weight from the JSON and creates a corresponding Product instance.
     *
     * @param json         The JSON element to deserialize.
     * @param typeOfT      The type of the object to deserialize into (Product).
     * @param context      The deserialization context.
     * @return A Product object created from the JSON data.
     * @throws JsonParseException If the JSON format is unexpected or invalid for a Product.
     */
    @Override
    public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject;

        // Check if the JSON element is an object or a primitive string
        if (json.isJsonObject()) {
            jsonObject = json.getAsJsonObject();
        } else if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
            // Handle the case where product type is provided as a string
            String productTypeStr = json.getAsString();
            jsonObject = new JsonObject();
            jsonObject.addProperty("productType", productTypeStr);
        } else {
            throw new JsonParseException("Unexpected JSON format for product.");
        }

        // Extract product properties from the JSON object
        String productTypeStr = jsonObject.get("productType").getAsString();
        String name = jsonObject.get("name").getAsString();
        double price = jsonObject.get("price").getAsDouble();
        int weight = jsonObject.get("weight").getAsInt();

        // Use the ProductFactory to create the product based on its type
        return new ProductFactory().createProduct(productTypeStr, name, price, weight);
    }

    /**
     * Serializes a Product object into a JSON element.
     * The method converts the product's type, name, price, and weight into a JSON object.
     *
     * @param src           The Product object to serialize.
     * @param typeOfSrc     The type of the object to serialize (Product).
     * @param context       The serialization context.
     * @return A JSON representation of the Product object.
     */
    @Override
    public JsonElement serialize(Product src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        // Add product properties to the JSON object
        jsonObject.addProperty("productType", src.getProductType().name());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("price", src.getPrice());
        jsonObject.addProperty("weight", src.getWeight());

        return jsonObject;
    }
}
