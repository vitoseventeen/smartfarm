package cz.cvut.omo.model.animal;

public class Cow extends Animal {
    public Cow(int dailyFoodIntake) {
        super("Cow", 4, dailyFoodIntake);
    }

    @Override
    public void produce() {
        System.out.println("The cow is producing milk.");
    }
}
