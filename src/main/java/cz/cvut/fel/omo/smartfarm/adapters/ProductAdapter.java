package cz.cvut.fel.omo.smartfarm.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import cz.cvut.fel.omo.smartfarm.model.products.*;

import java.lang.reflect.Type;

public class ProductAdapter extends AAdapter<Product> {

    @Override
    public Product deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String productTypeStr = jsonObject.get("productType").getAsString();
        ProductType productType = ProductType.valueOf(productTypeStr.toUpperCase());


        return createProductByType(productType, jsonObject);
    }

    private Product createProductByType(ProductType productType, JsonObject jsonObject) {

        String name = jsonObject.get("name").getAsString();
        int price = jsonObject.get("price").getAsInt();
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
