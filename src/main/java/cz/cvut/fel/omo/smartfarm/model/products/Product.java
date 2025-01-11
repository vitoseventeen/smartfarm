package cz.cvut.fel.omo.smartfarm.model.products;

public abstract class Product {
    private final String name;
    private final double price;
    private final int weight;
    private final ProductType productType;

    public Product(String name, double price, int weight, ProductType productType) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", productType=" + productType +
                '}';
    }

    public Product copyWith(String name, Double price, Integer weight, ProductType productType) {
        return new Product(
                name != null ? name : this.name,
                price != null ? price : this.price,
                weight != null ? weight : this.weight,
                productType != null ? productType : this.productType
        ) {
        };
    }

}

