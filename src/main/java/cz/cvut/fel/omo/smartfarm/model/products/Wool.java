package cz.cvut.fel.omo.smartfarm.model.products;

public class Wool extends Product<Wool> {
    public Wool(String name, double price, int weight) {
        super(name, price, weight, ProductType.WOOL);
    }

    @Override
    public Wool copyWith(String name, double price, int weight) {
        return new Wool(name, price, weight);
    }
}

