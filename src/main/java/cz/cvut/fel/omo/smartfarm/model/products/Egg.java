package cz.cvut.fel.omo.smartfarm.model.products;

public class Egg extends Product {
    public Egg(String name, int price, int weight) {
        super(name, price, weight, ProductType.EGG);  // Передаем тип продукта
    }
}

