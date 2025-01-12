package cz.cvut.fel.omo.smartfarm.model.products;

/**
 * This enum represents the different types of products available in the farm.
 * Each product type corresponds to a specific type of product, such as Egg, Meat, Milk, and Wool.
 */
public enum ProductType {
    EGG("egg"),
    MEAT("meat"),
    MILK("milk"),
    WOOL("wool");

    // The display name of the product type
    private final String displayName;

    /**
     * Constructor that initializes a ProductType with the specified display name.
     *
     * @param displayName The name of the product type (e.g., "egg", "meat", etc.).
     */
    ProductType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the display name of the product type.
     *
     * @return The display name of the product type.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Returns a string representation of the product type, which is its display name.
     *
     * @return The display name of the product type.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
