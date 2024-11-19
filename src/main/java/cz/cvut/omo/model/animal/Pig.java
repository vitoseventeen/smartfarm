package cz.cvut.omo.model.animal;

public class Pig extends Animal {
    public Pig(int dailyFoodIntake) {
        super("Pig", 3, dailyFoodIntake);
    }

    @Override
    public void produce() {
        System.out.println("The pig is growing for meat.");
    }
}
