package cz.cvut.omo.model.build;


import cz.cvut.omo.model.animal.Animal;

import java.util.List;

public class Stable extends Building {
    private List<Animal> animals;


    public Stable(String name, int capacity, List<Animal> animals) {
        super(name, 40, BuildingType.STABLE, capacity);
        this.animals = animals;
    }

    @Override
    public void performFunction() {
        System.out.println(getType() + " " + getName() + " используется для содержания животных.");
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}