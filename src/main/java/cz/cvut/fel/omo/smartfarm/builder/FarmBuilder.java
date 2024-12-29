package cz.cvut.fel.omo.smartfarm.builder;

import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Barn;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Product;
import cz.cvut.fel.omo.smartfarm.strategy.ProduceStrategy;

import java.util.ArrayList;
import java.util.List;

public class FarmBuilder {
    public String name;
    public List<Field> fields = new ArrayList<>();
    public List<Farmer> farmers = new ArrayList<>();
    public List<Building> buildings = new ArrayList<>();
    public List<Equipment> equipments = new ArrayList<>();
    public List<Animal> animals = new ArrayList<>();
    public List<Product> products = new ArrayList<>();

    public FarmBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FarmBuilder addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public FarmBuilder addField(Field field) {
        this.fields.add(field);
        return this;
    }

    public FarmBuilder addFields(List<Field> fields) {
        this.fields.addAll(fields);
        return this;
    }

    public FarmBuilder addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
        return this;
    }

    public FarmBuilder addFarmers(List<Farmer> farmers) {
        this.farmers.addAll(farmers);
        return this;
    }

    public FarmBuilder addBuilding(Building building) {
        this.buildings.add(building);
        return this;
    }

    public FarmBuilder addBuildings(List<Building> buildings) {
        this.buildings.addAll(buildings);
        return this;
    }

    public FarmBuilder addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
        return this;
    }

    public FarmBuilder addAnimal(Animal animal) {
        this.animals.add(animal);
        return this;
    }

    public Farm build() {
        return new Farm(this);
    }

    public double getProductPrice() {
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }
}
