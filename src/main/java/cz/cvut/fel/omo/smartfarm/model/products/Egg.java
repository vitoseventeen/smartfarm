package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This class represents an Egg, which is a type of Product.
 * It extends the Product class and provides specific implementation for the Egg product.
 */
public class Egg extends Product<Egg> {

    /**
     * Constructor that initializes an Egg object with the specified name, price, and weight.
     *
     * @param name  The name of the egg product.
     * @param price The price of the egg product.
     * @param weight The weight of the egg product.
     */
    public Egg(String name, double price, int weight) {
        super(name, price, weight, ProductType.EGG);
    }

    /**
     * Creates a copy of the current Egg object with the specified name, price, and weight.
     * This method allows creating a new instance of Egg with different properties.
     *
     * @param name   The new name for the egg.
     * @param price  The new price for the egg.
     * @param weight The new weight for the egg.
     * @return A new Egg object with the specified name, price, and weight.
     */
    @Override
    public Egg copyWith(String name, double price, int weight) {
        return new Egg(name, price, weight);
    }
}
