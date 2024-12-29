package cz.cvut.fel.omo.smartfarm.model.products;

public class Milk extends Product {
    public Milk(String name, int price, int weight) {
        super(name, price, weight, ProductType.MILK);
    }
}
