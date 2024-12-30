package cz.cvut.fel.omo.smartfarm.model.products;

public class Meat extends Product {
    public Meat(String name, double price, int weight) {
        super(name, price, weight, ProductType.MEAT);  // Передаем тип продукта
    }
}
