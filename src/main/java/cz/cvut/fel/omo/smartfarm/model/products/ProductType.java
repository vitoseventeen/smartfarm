package cz.cvut.fel.omo.smartfarm.model.products;

public enum ProductType {
    EGG("Egg"),
    MEAT("Meat"),
    MILK("Milk"),
    WOOL("Wool");

    private final String displayName;

    ProductType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

