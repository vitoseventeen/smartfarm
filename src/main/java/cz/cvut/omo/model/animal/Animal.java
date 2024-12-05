package cz.cvut.omo.model.animal;

public abstract class Animal {
    private String type;
    private final int takesPlaces;
    private final int dailyFoodIntake;

    public Animal(String type, int takesPlaces, int dailyFoodIntake) {
        this.type = type;
        this.takesPlaces = takesPlaces;
        this.dailyFoodIntake = dailyFoodIntake;
    }

    public String getType() {
        return type;
    }

    public int getTakesPlaces() {
        return takesPlaces;
    }

    public int getDailyFoodIntake() {
        return dailyFoodIntake;
    }

    //TODO: IMPLEMENT THIS METHOD IN EVERY CLASS + ADD SUBCLASSES FOR PRODUCTS
    public abstract void produce();  // Метод, который будет реализован в каждом классе животного

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", takesPlaces=" + takesPlaces +
                '}';
    }
}
