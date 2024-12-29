package cz.cvut.fel.omo.smartfarm.model.build;

import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Building {

    private static final Logger logger = Logger.getLogger(Building.class.getName());
    private double area;
    private String name;
    private BuildingType type;
    private int capacity;
    private int currentUsage;
    private int level;
    private List<Product> products;
    private double productPrice;

    public Building(String name, double area, BuildingType type, int capacity) {
        this.name = name;
        this.area = area;
        this.type = type;
        this.capacity = capacity;
        this.currentUsage = 0;
        this.level = 0;
        this.products = new ArrayList<>();
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
Area: %.2f sq.m
Capacity: %d
Current Usage: %d
""",
                name, type, area, capacity, currentUsage
        );
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        }
    }

    public void levelUp() {
        level++;
        System.out.println("Building " + name + " has been upgraded to a " + level + "level.");
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }

    public abstract void performFunction();
}
