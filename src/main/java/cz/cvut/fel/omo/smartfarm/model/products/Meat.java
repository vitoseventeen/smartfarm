package cz.cvut.fel.omo.smartfarm.model.products;

public class Meat extends Product<Meat> {
    public Meat(String name, double price, int weight) {
        super(name, price, weight, ProductType.MEAT);
    }

    @Override
    public Meat copyWith(String name, double price, int weight) {
        return new Meat(name, price, weight);
    }
}
