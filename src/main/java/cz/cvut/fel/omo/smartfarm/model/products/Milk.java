package cz.cvut.fel.omo.smartfarm.model.products;

public class Milk extends Product<Milk> {
    public Milk(String name, double price, int weight) {
        super(name, price, weight, ProductType.MILK);
    }

    @Override
    public Milk copyWith(String name, double price, int weight) {
        return new Milk(name, price, weight);
    }
}
