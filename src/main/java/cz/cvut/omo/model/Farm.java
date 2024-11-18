package cz.cvut.omo.model;

import java.util.List;

public class Farm {
    private List<Field> fields;
    private List<Farmer> farmers;
    private List<Building> buildings;
    private List<Machine> machines;
    private List<Animal> animals;

    public Farm(List<Field> fields, List<Farmer> farmers, List<Building> buildings, List<Machine> machines, List<Animal> animals) {
        this.fields = fields;
        this.farmers = farmers;
        this.buildings = buildings;
        this.machines = machines;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "fields=" + fields +
                ", farmers=" + farmers +
                ", buildings=" + buildings +
                ", machines=" + machines +
                ", animals=" + animals +
                '}';
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
