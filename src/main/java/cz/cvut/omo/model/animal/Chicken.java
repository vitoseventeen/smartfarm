package cz.cvut.omo.model.animal;

public class Chicken extends Animal {
    public Chicken(int dailyFoodIntake) {
        super("Chicken", 1, dailyFoodIntake);
    }

    @Override
    public void produce() {
        System.out.println("The chicken is laying eggs.");
    }
}