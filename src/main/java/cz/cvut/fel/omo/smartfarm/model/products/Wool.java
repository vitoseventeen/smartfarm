package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This class represents Wool, which is a type of Product.
 * It extends the Product class and provides specific implementation for the Wool product.
 */
public class Wool extends Product<Wool> {

    /**
     * Constructor that initializes a Wool object with the specified name, price, and weight.
     *
     * @param name   The name of the wool product.
     * @param price  The price of the wool product.
     * @param weight The weight of the wool product.
     */
    public Wool(String name, double price, int weight) {
        super(name, price, weight, ProductType.WOOL);
    }

    /**
     * Creates a copy of the current Wool object with the specified name, price, and weight.
     * This method allows creating a new instance of Wool with different properties.
     *
     * @param name   The new name for the wool.
     * @param price  The new price for the wool.
     * @param weight The new weight for the wool.
     * @return A new Wool object with the specified name, price, and weight.
     */
    @Override
    public Wool copyWith(String name, double price, int weight) {
        return new Wool(name, price, weight);
    }
}
