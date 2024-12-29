package cz.cvut.fel.omo.smartfarm.model.products;

public class Wool extends Product {
    public Wool(String name, int price, int weight) {
        super(name, price, weight, ProductType.WOOL);
    }
}

