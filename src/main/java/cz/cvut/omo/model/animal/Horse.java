package cz.cvut.omo.model.animal;

public class Horse extends Animal {

    public Horse(int dailyFoodIntake) {
        super("Horse", 5, dailyFoodIntake);
    }

    @Override
    public String toString() {
        return String.format("Horse{type='%s', takesPlaces=%d, health=%d}", getType(), getTakesPlaces());
    }

    @Override
    public void produce() {
        System.out.println("The horse produces manure.");
    }

}
