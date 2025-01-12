package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.products.*;

public class ProductFactory extends BaseFactory<Product> {
    public ProductFactory() {
        register(ProductType.EGG.toString().toLowerCase(), () -> new Egg("Default Egg", 5.0, 1));
        register(ProductType.MEAT.toString().toLowerCase(), () -> new Meat("Default Meat", 50.0, 1));
        register(ProductType.WOOL.toString().toLowerCase(), () -> new Wool("Default Wool", 20.0, 1));
        register(ProductType.MILK.toString().toLowerCase(), () -> new Milk("Default Milk", 10.0, 1));

    }


    public Product createProduct(String type, String name, double price, int weight) {
        Product product = super.create(type.toLowerCase());
        return product.copyWith(name, price, weight);
    }
}
