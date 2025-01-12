package cz.cvut.fel.omo.smartfarm.model.products;

public class Egg extends Product<Egg> {
    public Egg(String name, double price, int weight) {
        super(name, price, weight, ProductType.EGG);
    }

    @Override
    public Egg copyWith(String name, double price, int weight) {
        return new Egg(name, price, weight);
    }
}

