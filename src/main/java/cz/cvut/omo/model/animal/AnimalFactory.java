package cz.cvut.omo.model.animal;

public class AnimalFactory {
    public static Animal createAnimal(String type, int dailyFoodIntake) {
        return switch (type.toLowerCase()) {
            case "chicken" -> new Chicken(dailyFoodIntake);
            case "cow" -> new Cow(dailyFoodIntake);
            case "horse" -> new Horse(dailyFoodIntake);
            case "pig" -> new Pig(dailyFoodIntake);
            default -> throw new IllegalArgumentException("Unknown animal type: " + type);
        };
    }
}
