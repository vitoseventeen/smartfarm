package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This abstract class represents a generic Product with common attributes such as name, price, weight, and product type.
 * The class is designed to be extended by specific product types like Egg, Milk, Meat, etc.
 * It also defines an abstract method for creating a copy of the product with modified attributes.
 *
 * @param <T> The type of the product subclass extending Product (e.g., Egg, Milk, etc.).
 */
public abstract class Product<T extends Product<T>> {
    private final String name;
    private final double price;
    private final int weight;
    private final ProductType productType;

    /**
     * Constructor that initializes a Product with the specified name, price, weight, and product type.
     *
     * @param name        The name of the product.
     * @param price       The price of the product.
     * @param weight      The weight of the product.
     * @param productType The type of the product (e.g., EGG, MILK, etc.).
     */
    public Product(String name, double price, int weight, ProductType productType) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.productType = productType;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the weight of the product.
     *
     * @return The weight of the product.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the product type (e.g., EGG, MILK).
     *
     * @return The product type.
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Returns a string representation of the Product object, including its name, price, weight, and product type.
     *
     * @return A string representation of the Product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", productType=" + productType +
                '}';
    }

    /**
     * Creates a copy of the current Product object with the specified name, price, and weight.
     * This method must be implemented by subclasses to create a new instance of the specific product type.
     *
     * @param name   The new name for the product.
     * @param price  The new price for the product.
     * @param weight The new weight for the product.
     * @return A new instance of the specific product type with the updated properties.
     */
    public abstract T copyWith(String name, double price, int weight);
}
