package cz.cvut.fel.omo.smartfarm.builder;

import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * FarmBuilder is a utility class for constructing a {@link Farm} instance.
 * It provides a fluent API for adding various elements such as fields, farmers,
 * buildings, equipment, animals, and products to a farm configuration.
 */
public class FarmBuilder {

    /**
     * The name of the farm being built.
     */
    public String name;

    /**
     * List of fields in the farm.
     */
    public List<Field> fields = new ArrayList<>();

    /**
     * List of farmers in the farm.
     */
    public List<Farmer> farmers = new ArrayList<>();

    /**
     * List of buildings in the farm.
     */
    public List<Building> buildings = new ArrayList<>();

    /**
     * List of equipment in the farm.
     */
    public List<Equipment> equipments = new ArrayList<>();

    /**
     * List of animals in the farm.
     */
    public List<Animal> animals = new ArrayList<>();

    /**
     * List of products produced by the farm.
     */
    public List<Product> products = new ArrayList<>();

    /**
     * Sets the name of the farm.
     *
     * @param name the name of the farm
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Adds a product to the farm.
     *
     * @param product the product to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    /**
     * Adds a field to the farm.
     *
     * @param field the field to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addField(Field field) {
        this.fields.add(field);
        return this;
    }

    /**
     * Adds multiple fields to the farm.
     *
     * @param fields the list of fields to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addFields(List<Field> fields) {
        this.fields.addAll(fields);
        return this;
    }

    /**
     * Adds a farmer to the farm.
     *
     * @param farmer the farmer to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
        return this;
    }

    /**
     * Adds multiple farmers to the farm.
     *
     * @param farmers the list of farmers to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addFarmers(List<Farmer> farmers) {
        this.farmers.addAll(farmers);
        return this;
    }

    /**
     * Adds a building to the farm.
     *
     * @param building the building to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addBuilding(Building building) {
        this.buildings.add(building);
        return this;
    }

    /**
     * Adds multiple buildings to the farm.
     *
     * @param buildings the list of buildings to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addBuildings(List<Building> buildings) {
        this.buildings.addAll(buildings);
        return this;
    }

    /**
     * Adds equipment to the farm.
     *
     * @param equipment the equipment to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
        return this;
    }

    /**
     * Adds multiple equipment to the farm.
     *
     * @param equipment the list of equipment to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addEquipments(List<Equipment> equipment) {
        this.equipments.addAll(equipment);
        return this;
    }

    /**
     * Adds an animal to the farm.
     *
     * @param animal the animal to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addAnimal(Animal animal) {
        this.animals.add(animal);
        return this;
    }

    /**
     * Adds multiple animals to the farm.
     *
     * @param animals the list of animals to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addAnimals(List<Animal> animals) {
        this.animals.addAll(animals);
        return this;
    }

    /**
     * Adds multiple products to the farm.
     *
     * @param products the list of products to be added
     * @return the current instance of {@link FarmBuilder}
     */
    public FarmBuilder addProducts(List<Product> products) {
        this.products.addAll(products);
        return this;
    }

    /**
     * Builds and returns a {@link Farm} instance based on the current configuration.
     *
     * @return a new {@link Farm} instance
     */
    public Farm build() {
        return new Farm(this);
    }

    /**
     * Calculates the total price of all products in the farm.
     *
     * @return the total price of products
     */
    public double getProductPrice() {
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }
}
