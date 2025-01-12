package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This class represents Meat, which is a type of Product.
 * It extends the Product class and provides specific implementation for the Meat product.
 */
public class Meat extends Product<Meat> {

    /**
     * Constructor that initializes a Meat object with the specified name, price, and weight.
     *
     * @param name   The name of the meat product.
     * @param price  The price of the meat product.
     * @param weight The weight of the meat product.
     */
    public Meat(String name, double price, int weight) {
        super(name, price, weight, ProductType.MEAT);
    }

    /**
     * Creates a copy of the current Meat object with the specified name, price, and weight.
     * This method allows creating a new instance of Meat with different properties.
     *
     * @param name   The new name for the meat.
     * @param price  The new price for the meat.
     * @param weight The new weight for the meat.
     * @return A new Meat object with the specified name, price, and weight.
     */
    @Override
    public Meat copyWith(String name, double price, int weight) {
        return new Meat(name, price, weight);
    }
}
