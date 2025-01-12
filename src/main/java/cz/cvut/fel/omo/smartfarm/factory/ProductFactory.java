package cz.cvut.fel.omo.smartfarm.factory;

import cz.cvut.fel.omo.smartfarm.model.products.*;

/**
 * This class is a factory for creating Product objects.
 * It extends the BaseFactory and registers the supported product types,
 * such as Egg, Meat, Wool, and Milk.
 * It provides functionality to create products of a specified type with additional properties.
 */
public class ProductFactory extends BaseFactory<Product> {

    /**
     * Constructor that registers the available product types with their corresponding creation methods.
     * The factory supports creating various types of products such as Egg, Meat, Wool, and Milk.
     */
    public ProductFactory() {
        // Register product types with their respective creation methods
        register(ProductType.EGG.toString().toLowerCase(), () -> new Egg("Default Egg", 5.0, 1));
        register(ProductType.MEAT.toString().toLowerCase(), () -> new Meat("Default Meat", 50.0, 1));
        register(ProductType.WOOL.toString().toLowerCase(), () -> new Wool("Default Wool", 20.0, 1));
        register(ProductType.MILK.toString().toLowerCase(), () -> new Milk("Default Milk", 10.0, 1));
    }

    /**
     * Creates a Product object of the specified type with a given name, price, and weight.
     * This method uses the create method from the BaseFactory to instantiate the correct Product subclass,
     * and then calls the copyWith method to set the name, price, and weight.
     *
     * @param type   The type of product to create (e.g., "egg", "meat", etc.).
     * @param name   The name of the product.
     * @param price  The price of the product.
     * @param weight The weight of the product.
     * @return A new Product object with the specified type, name, price, and weight.
     */
    public Product createProduct(String type, String name, double price, int weight) {
        // Create the product object based on the specified type
        Product product = super.create(type.toLowerCase());

        // Set the name, price, and weight of the created product
        return product.copyWith(name, price, weight);
    }
}
