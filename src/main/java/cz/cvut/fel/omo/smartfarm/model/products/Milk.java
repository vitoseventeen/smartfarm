package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This class represents Milk, which is a type of Product.
 * It extends the Product class and provides specific implementation for the Milk product.
 */
public class Milk extends Product<Milk> {

    /**
     * Constructor that initializes a Milk object with the specified name, price, and weight.
     *
     * @param name   The name of the milk product.
     * @param price  The price of the milk product.
     * @param weight The weight of the milk product.
     */
    public Milk(String name, double price, int weight) {
        super(name, price, weight, ProductType.MILK);
    }

    /**
     * Creates a copy of the current Milk object with the specified name, price, and weight.
     * This method allows creating a new instance of Milk with different properties.
     *
     * @param name   The new name for the milk.
     * @param price  The new price for the milk.
     * @param weight The new weight for the milk.
     * @return A new Milk object with the specified name, price, and weight.
     */
    @Override
    public Milk copyWith(String name, double price, int weight) {
        return new Milk(name, price, weight);
    }
}
