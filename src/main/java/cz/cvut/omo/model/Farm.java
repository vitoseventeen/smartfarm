package cz.cvut.omo.model;

import cz.cvut.omo.model.animal.Animal;
import cz.cvut.omo.model.build.Building;
import cz.cvut.omo.model.equipment.Equipment;
import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.field.Field;

import java.util.List;

public class Farm {
    private String name;
    private List<Field> fields;
    private List<Farmer> farmers;
    private List<Building> buildings;
    private List<Equipment> equipments;
    private List<Animal> animals;

    public Farm(String name, List<Field> fields, List<Farmer> farmers, List<Building> buildings, List<Equipment> equipments, List<Animal> animals) {
        this.name = name;
        this.fields = fields;
        this.farmers = farmers;
        this.buildings = buildings;
        this.equipments = equipments;
        this.animals = animals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Farm name
        sb.append("Ферма: ").append(name).append("\n");

        // Add fields, farmers, buildings, machines, and animals using a helper method
        appendListInfo(sb, "Поле", fields);
        appendListInfo(sb, "Фермеры", farmers);
        appendListInfo(sb, "Здания", buildings);
        appendListInfo(sb, "Оборудование (Машины)", equipments);
        appendListInfo(sb, "Животные", animals);

        return sb.toString();
    }

    // Приватный метод для добавления информации о списке объектов в строку
    private <T> void appendListInfo(StringBuilder sb, String title, List<T> list) {
        sb.append("|-- ").append(title).append("\n");
        if (list != null && !list.isEmpty()) {
            for (T item : list) {
                sb.append("|    - ").append(item).append("\n");
            }
        } else {
            sb.append("|    - Нет ").append(title.toLowerCase()).append(".\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        if (fields == null) return;
        this.fields = fields;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        if (farmers == null) return;
        this.farmers = farmers;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        if (buildings == null) return;
        this.buildings = buildings;
    }

    public List<Equipment> getMachines() {
        return equipments;
    }

    public void setMachines(List<Equipment> equipments) {
        if (equipments == null) return;
        this.equipments = equipments;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        if (animals == null) return;
        this.animals = animals;
    }
}
