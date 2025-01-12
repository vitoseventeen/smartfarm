package cz.cvut.fel.omo.smartfarm.strategy.data;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.factory.BuildingFactory;
import cz.cvut.fel.omo.smartfarm.factory.ProductFactory;
import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.*;
import cz.cvut.fel.omo.smartfarm.model.animal.Animal;
import cz.cvut.fel.omo.smartfarm.factory.AnimalFactory;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleFarmDataStrategy implements FarmDataStrategy {
    private final Scanner scanner;

    public ConsoleFarmDataStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Optional<Farm> read() {
        String name = readString("Enter farm name: ");
        List<Field> fields = readList("field", this::readField);
        List<Farmer> farmers = readList("farmer", this::readFarmer);
        List<Building> buildings = readList("building", this::readBuilding);
        List<Equipment> equipment = readList("equipment", this::readEquipment);
        List<Animal> animals = readList("animal", this::readAnimal);
        List<Product> products = readList("product", this::readProduct);

        FarmBuilder builder = new FarmBuilder()
                .setName(name)
                .addFields(fields)
                .addFarmers(farmers)
                .addBuildings(buildings)
                .addProducts(products)
                .addEquipments(equipment)
                .addAnimals(animals);

        return Optional.ofNullable(builder.build());
    }

    private <T> List<T> readList(String itemType, Supplier<T> reader) {
        List<T> list = new ArrayList<>();
        while (true) {
            AppLogger.getInstance().logHint("Do you want to add a " + itemType + "? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            try {
                if ("yes".equals(answer)) {
                    list.add(reader.get());
                } else if ("no".equals(answer)) {
                    break;
                } else {
                    AppLogger.getInstance().logError("Invalid input. Please answer with 'yes' or 'no'.");
                }
            } catch (RuntimeException e) {
                AppLogger.getInstance().logError(e.getMessage());
            }

        }
        return list;
    }

    // Read Field
    private Field readField() {
        AppLogger.getInstance().logInfo("Enter field data:");
        String cropType = readString("  Crop type: ");
        int fieldSize = readInt("  Field size: ", 1, Integer.MAX_VALUE);
        return new Field(cropType, fieldSize);
    }

    // Read Farmer
    private Farmer readFarmer() {
        AppLogger.getInstance().logInfo("Enter farmer data:");
        String name = readString("  Name: ");
        int age = readInt("  Age: ", 1, 120);
        return new Farmer(name, age, new WorkingState());
    }

    // Read Building
    private Building readBuilding() {
        AppLogger.getInstance().logInfo("Enter building data:");
        BuildingType type = readBuildingType();
        String name = readString("  Name: ");
        int capacity = readInt("  Capacity: ", 1, Integer.MAX_VALUE);
        return new BuildingFactory().createBuilding(type.toString(), name, capacity);
    }

    private BuildingType readBuildingType() {
        BuildingType type = null;
        while (type == null) {
            AppLogger.getInstance().logInfo("  Select Building Type:");
            for (BuildingType buildingType : BuildingType.values()) {
                AppLogger.getInstance().logInfo("    - " + buildingType.name() + " (" + buildingType.getDisplayName() + ")");
            }

            String typeInput = readString("  Type: ").toUpperCase();

            try {
                type = BuildingType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                AppLogger.getInstance().logError("Invalid building type. Please choose a valid type from the list.");
            }
        }
        return type;
    }

    // Read Equipment
    private Equipment readEquipment() {
        AppLogger.getInstance().logInfo("Enter equipment data:");
        String equipmentType = readString("  Is it a Machine or a Tool? (machine/tool): ").toLowerCase();
        String name = readString("  Name: ");
        if ("machine".equals(equipmentType)) {
            return readMachine(name);
        } else {
            return readTool(name);
        }
    }

    private Machine readMachine(String name) {
        int fuelLevel = readInt("  Fuel level: ", 0, 100);
        return new Machine(name, fuelLevel);
    }

    private Tool readTool(String name) {
        String usageType = readString("  Usage type (e.g., 'digging', 'cutting'): ");
        return new Tool(name, usageType);
    }

    // Read Animal
    private Animal readAnimal() {
        AppLogger.getInstance().logInfo("Enter animal data:");
        String type = readAnimalType();
        Animal animal = new AnimalFactory().create(type);
        int takesPlaces = readInt("  Takes Places: ", 1, Integer.MAX_VALUE);
        int dailyFoodIntake = readInt("  Daily Food Intake: ", 1, Integer.MAX_VALUE);
        animal.setType(type);
        return animal;
    }

    private String readAnimalType() {
        String type;
        while (true) {
            AppLogger.getInstance().logInfo("  Select Animal Type:");
            type = readString("  Type (cow, chicken, sheep, pig): ").toLowerCase();
            if (type.equals("cow") || type.equals("chicken") || type.equals("sheep") || type.equals("pig")) {
                break;
            } else {
                AppLogger.getInstance().logInfo("Invalid input. Please enter 'cow', 'chicken', 'sheep', or 'pig'.");
            }
        }
        return type;
    }

    // Read Product
    private Product readProduct() {
        AppLogger.getInstance().logInfo("Enter product data:");
        ProductType productType = readProductType();
        String name = readString("  Product Name: ");
        double price = readDouble("  Price: ");
        int weight = readInt("  Weight: ", 1, Integer.MAX_VALUE);
        return new ProductFactory().createProduct(productType.toString(), name, price, weight);
    }

    private ProductType readProductType() {
        ProductType productType = null;
        while (productType == null) {
            AppLogger.getInstance().logInfo("  Select Product Type:");
            for (ProductType type : ProductType.values()) {
                AppLogger.getInstance().logInfo("    - " + type.name() + " (" + type.getDisplayName() + ")");
            }

            String typeInput = readString("  Type: ").toUpperCase();

            try {
                productType = ProductType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                AppLogger.getInstance().logError("Invalid product type. Please choose a valid type from the list.");
            }
        }
        return productType;
    }

    private double readDouble(String prompt) {
        double value = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo(prompt);
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Value must be non-negative. Please try again.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid number.");
            }
        }
        return value;
    }

    private String readString(String prompt) {
        String input;
        while (true) {
            AppLogger.getInstance().logInfo(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            AppLogger.getInstance().logWarning("Input cannot be empty. Please try again.");
        }
        return input;
    }

    private int readInt(String prompt, int minValue, int maxValue) {
        int value = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo(prompt);
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= minValue && value <= maxValue) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Value must be between " + minValue + " and " + maxValue + ". Please try again.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }
        return value;
    }
}
