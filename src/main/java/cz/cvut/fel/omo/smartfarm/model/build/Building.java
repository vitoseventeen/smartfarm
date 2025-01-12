package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Abstract base class for various types of buildings in the smart farm system.
 * Handles product storage, building capacity, and specialized functions for each building type.
 */
public abstract class Building<T extends Building<T>> {

    private static final Logger logger = Logger.getLogger(Building.class.getName());
    private String name;
    private BuildingType type;
    private int capacity;
    private int currentUsage;
    private List<Product> products = new ArrayList<>();
    private double productPrice;

    /**
     * Initializes a building with a default capacity and name based on its type.
     *
     * @param type The type of the building, determining its default properties.
     */
    public Building(BuildingType type) {
        this.type = type;
        this.name = "Default " + type.getDisplayName();
        this.capacity = 100;
        this.currentUsage = 0;
    }

    /**
     * Initializes a building with specified name, type, and capacity.
     *
     * @param name The name of the building.
     * @param type The type of the building, defining its functionality and role.
     * @param capacity The maximum number of products the building can hold.
     */
    public Building(String name, BuildingType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.currentUsage = 0;
    }

    /**
     * Adds a product to the building if there is enough space. Logs the action.
     *
     * @param product The product to add to the building.
     */
    public void addProduct(Product product) {
        if (currentUsage < capacity) {
            products.add(product);
            currentUsage++;
            productPrice += product.getPrice();
            logger.info("Product " + product.getName() + " added to " + name);
        } else {
            logger.warning("No space in " + name + " to add product " + product.getName());
        }
    }

    /**
     * Returns the total price of all products stored in the building.
     *
     * @return The total price of products.
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Returns the list of products stored in the building.
     *
     * @return The list of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Creates a copy of this building with specified name and capacity. Implementation varies among subclasses.
     *
     * @param name The new name for the building copy.
     * @param capacity The new capacity for the building copy.
     * @return A new instance of T, a subclass of Building.
     */
    protected abstract T createCopy(String name, int capacity);

    /**
     * Abstract method to be implemented by subclasses to define the building's specific function.
     */
    public abstract void performFunction();
}
