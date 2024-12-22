package cz.cvut.fel.omo.smartfarm.model.animal;

import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.strategy.ProduceStrategy;

public abstract class Animal {
    private String type;
    private final int takesPlaces;
    private final int dailyFoodIntake;
    private ProduceStrategy produceStrategy;

    public Animal(String type, int takesPlaces, int dailyFoodIntake, ProduceStrategy produceStrategy) {
        this.type = type;
        this.takesPlaces = takesPlaces;
        this.dailyFoodIntake = dailyFoodIntake;
        this.produceStrategy = produceStrategy;
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

    public void setProduceStrategy(ProduceStrategy produceStrategy) {
        this.produceStrategy = produceStrategy;
    }

    public void produce(Building barn) {
        produceStrategy.produce(barn);
    }
}
