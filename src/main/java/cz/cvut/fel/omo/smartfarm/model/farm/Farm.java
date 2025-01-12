package cz.cvut.fel.omo.smartfarm.model.farm;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Product;

import java.util.List;

/**
 * Represents the entirety of a farm, encapsulating all its components including fields, farmers, buildings, equipment,
 * animals, and products.
 */
public class Farm {
    private final String name;
    private final List<Field> fields;
    private final List<Farmer> farmers;
    private final List<Building> buildings;
    private final List<Equipment> equipments;
    private final List<Animal> animals;
    private final List<Product> products;

    /**
     * Constructs a farm using a builder pattern, which allows for flexible initialization of farm components.
     *
     * @param farmBuilder The builder containing all necessary data to initialize the farm.
     */
    public Farm(FarmBuilder farmBuilder) {
        this.name = farmBuilder.name;
        this.fields = farmBuilder.fields;
        this.farmers = farmBuilder.farmers;
        this.buildings = farmBuilder.buildings;
        this.equipments = farmBuilder.equipments;
        this.animals = farmBuilder.animals;
        this.products = farmBuilder.products;
    }

    /**
     * Calculates the total price of all products produced on the farm.
     *
     * @return The total price of all products.
     */
    public double getTotalProductPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    /**
     * Provides a detailed string representation of the farm and all its components.
     *
     * @return A string detailing the farm's composition and the total value of its products.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm: ").append(name).append("\n");

        appendListInfo(sb, "Fields", fields);
        appendListInfo(sb, "Farmers", farmers);
        appendListInfo(sb, "Buildings", buildings);
        appendListInfo(sb, "Equipments", equipments);
        appendListInfo(sb, "Animals", animals);
        appendListInfo(sb, "Products", products);

        sb.append("|-- Product Price: $").append(getTotalProductPrice()).append("\n");

        return sb.toString();
    }

    private <T> void appendListInfo(StringBuilder sb, String title, List<T> list) {
        sb.append("|-- ").append(title).append("\n");
        if (list != null && !list.isEmpty()) {
            list.forEach(item -> sb.append("|    - ").append(item).append("\n"));
        } else {
            sb.append("|    - No ").append(title.toLowerCase()).append(" available.\n");
        }
    }

    // Getter methods
    public String getName() { return name; }
    public List<Field> getFields() { return fields; }
    public List<Farmer> getFarmers() { return farmers; }
    public List<Building> getBuildings() { return buildings; }
    public List<Equipment> getEquipments() { return equipments; }
    public List<Animal> getAnimals() { return animals; }
}
