package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Abstract class representing a building in the smart farm system.
 * This class manages the building's name, type, capacity, products, and their prices.
 * It allows products to be added, manages the building's current usage, and provides a way to copy building instances.
 *
 * @param <T> The type of the building (used for building-specific subclasses).
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
     * Constructs a building with a specified type and default capacity of 100.
     * Initializes the name based on the building type.
     *
     * @param type The type of the building (e.g., Barn, Stable).
     */
    public Building(BuildingType type) {
        this.type = type;
        this.name = "Default " + type.getDisplayName();
        this.capacity = 100;
        this.currentUsage = 0;
    }

    /**
     * Constructs a building with a specified name, type, and capacity.
     *
     * @param name The name of the building.
     * @param type The type of the building (e.g., Barn, Stable).
     * @param capacity The maximum capacity of the building.
     */
    public Building(String name, BuildingType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.currentUsage = 0;
    }

    /**
     * Adds a product to the building if there is available space.
     * If there is no space, a warning is logged.
     *
     * @param product The product to be added to the building.
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
     * Returns the total price of all products in the building.
     *
     * @return The total price of the products.
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Returns the list of products in the building.
     *
     * @return The list of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Returns a string representation of the building, including its name, type, capacity, and current usage.
     *
     * @return The string representation of the building.
     */
    @Override
    public String toString() {
        return String.format(
                """
                        Building Details:
                        -----------------
                        Name: %s
                        Type: %s
                        Capacity: %d
                        Current Usage: %d
                        """,
                name, type, capacity, currentUsage
        );
    }

    // Getters and setters for the building's properties

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

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }

    public void setProductPrice(double productPrice) {
        if (productPrice < 0) {
            return;
        }
        this.productPrice = productPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    /**
     * Creates a copy of the building with a new name and capacity.
     * This method also copies over the current usage, product list, and total product price.
     *
     * @param name The new name for the copied building.
     * @param capacity The new capacity for the copied building.
     * @return A new instance of the building with the specified name and capacity.
     */
    public T copyWith(String name, Integer capacity) {
        T copy = createCopy(name, capacity);
        copy.setCurrentUsage(this.currentUsage);
        copy.setProductPrice(this.productPrice);
        copy.setProducts(this.products);
        return copy;
    }

    /**
     * Abstract method to create a copy of the building.
     * Subclasses must implement this method to return a new instance of the building with the given name and capacity.
     *
     * @param name The new name for the copied building.
     * @param capacity The new capacity for the copied building.
     * @return A new instance of the building with the given name and capacity.
     */
    protected abstract T createCopy(String name, int capacity);

    /**
     * Performs the function of the building, which is specific to the type of building (e.g., keeping hay, providing shelter).
     * Subclasses must implement this method to define the building's behavior.
     */
    public abstract void performFunction();
}
