package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Building<T extends Building<T>> {

    private static final Logger logger = Logger.getLogger(Building.class.getName());
    private String name;
    private BuildingType type;
    private int capacity;
    private int currentUsage;


    private List<Product> products = new ArrayList<>();
    private double productPrice;

    public Building(BuildingType type) {
        this.type = type;
        this.name = "Default " + type.getDisplayName();

        this.capacity = 100;
        this.currentUsage = 0;
    }


    public Building(String name, BuildingType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.currentUsage = 0;
    }


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

    public double getProductPrice() {
        return productPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

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

    public T copyWith(String name, Integer capacity) {
        T copy = createCopy(name, capacity);
        copy.setCurrentUsage(this.currentUsage);
        copy.setProductPrice(this.productPrice);
        copy.setProducts(this.products);
        return copy;
    }

    protected abstract T createCopy(String name, int capacity);


    public abstract void performFunction();
}
