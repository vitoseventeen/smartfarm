package cz.cvut.fel.omo.smartfarm.model.animal;

public class AnimalFactory {

    public static Animal createAnimal(String type) {
        return switch (type.toLowerCase()) {
            case "cow" -> new Cow();
            case "chicken" -> new Chicken();
            case "sheep" -> new Sheep();
            case "pig" -> new Pig();
            default -> throw new IllegalArgumentException("Unknown animal type: " + type);
        };
    }
}
