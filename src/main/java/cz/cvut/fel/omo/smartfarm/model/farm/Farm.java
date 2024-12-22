package cz.cvut.fel.omo.smartfarm.model.farm;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.model.build.Building;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import java.util.List;

public class Farm {
    private final String name;
    private final List<Field> fields;
    private final List<Farmer> farmers;
    private final List<Building> buildings;
    private final List<Equipment> equipments;
    private final List<Animal> animals;

    public Farm(FarmBuilder farmBuilder) {
        this.name = farmBuilder.name;
        this.fields = farmBuilder.fields;
        this.farmers = farmBuilder.farmers;
        this.buildings = farmBuilder.buildings;
        this.equipments = farmBuilder.equipments;
        this.animals = farmBuilder.animals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm: ").append(name).append("\n");

        appendListInfo(sb, "Fields", fields);
        appendListInfo(sb, "Farmers", farmers);
        appendListInfo(sb, "Buildings", buildings);
        appendListInfo(sb, "Equipments (machines)", equipments);
        appendListInfo(sb, "Animals", animals);

        return sb.toString();
    }

    private <T> void appendListInfo(StringBuilder sb, String title, List<T> list) {
        sb.append("|-- ").append(title).append("\n");
        if (list != null && !list.isEmpty()) {
            for (T item : list) {
                sb.append("|    - ").append(item).append("\n");
            }
        } else {
            sb.append("|    - No ").append(title.toLowerCase()).append(".\n");
        }
    }

    public String getName() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
