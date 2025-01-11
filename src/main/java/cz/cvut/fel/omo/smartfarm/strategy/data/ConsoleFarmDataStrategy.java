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
        String name = readNonEmptyString("Enter farm name: ");

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

            if ("yes".equals(answer)) {
                list.add(reader.get());
            } else if ("no".equals(answer)) {
                break;
            } else {
                AppLogger.getInstance().logError("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
        return list;
    }

    private String readNonEmptyString(String prompt) {
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

    // Read Field
    private Field readField() {
        AppLogger.getInstance().logInfo("Enter field data:");
        String cropType = readNonEmptyString("  Crop type: ");
        int fieldSize = 0;

        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Field size: ");
                fieldSize = Integer.parseInt(scanner.nextLine().trim());
                if (fieldSize > 0) {
                    break;
                } else {
                    AppLogger.getInstance().logError("Field size must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        return new Field(cropType, fieldSize);
    }

    // Read Farmer
    private Farmer readFarmer() {
        AppLogger.getInstance().logInfo("Enter farmer data:");
        String name = readNonEmptyString("  Name: ");
        int age = 0;

        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Age: ");
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age > 0 && age <= 120) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Age must be between 1 and 120. Please try again.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        return new Farmer(name, age, new WorkingState());
    }

    // Read Building
    private Building readBuilding() {
        AppLogger.getInstance().logInfo("Enter building data:");

        BuildingType type = null;
        while (type == null) {
            AppLogger.getInstance().logInfo("  Select Building Type:");
            for (BuildingType buildingType : BuildingType.values()) {
                AppLogger.getInstance().logInfo("    - " + buildingType.name() + " (" + buildingType.getDisplayName() + ")");
            }

            String typeInput = readNonEmptyString("  Type: ").toUpperCase();

            try {
                type = BuildingType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                AppLogger.getInstance().logError("Invalid building type. Please choose a valid type from the list.");
            }
        }

        String name = readNonEmptyString("  Name: ");
        int capacity = 0;

        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Capacity: ");
                capacity = Integer.parseInt(scanner.nextLine().trim());
                if (capacity > 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Capacity must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        return new BuildingFactory().createBuilding(type.toString(), name, capacity);
    }

    private Equipment readEquipment() {
        AppLogger.getInstance().logInfo("Enter equipment data:");



        String equipmentType;
        while (true) {
            AppLogger.getInstance().logInfo("  Is it a Machine or a Tool? (machine/tool): ");
            equipmentType = scanner.nextLine().trim().toLowerCase();
            if ("machine".equals(equipmentType) || "tool".equals(equipmentType)) {
                break;
            } else {
                AppLogger.getInstance().logError("Invalid input. Please enter 'machine' or 'tool'.");
            }
        }
        String name = readNonEmptyString("  Name: ");

        if ("machine".equals(equipmentType)) {
            return readMachine(name);
        } else {
            return readTool(name);
        }
    }

    private Machine readMachine(String name) {
        int fuelLevel = 0;

        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Fuel level: ");
                fuelLevel = Integer.parseInt(scanner.nextLine().trim());
                if (fuelLevel >= 0 && fuelLevel <= 100) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Fuel level must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        return new Machine(name, fuelLevel);
    }

    private Tool readTool(String name) {
        String usageType = readNonEmptyString("  Usage type (e.g., 'digging', 'cutting'): ");
        return new Tool(name, usageType);
    }


    private Animal readAnimal() {
        AppLogger.getInstance().logInfo("Enter animal data:");
        String type;
        while (true) {
            AppLogger.getInstance().logInfo("  Select Animal Type:");
            type = readNonEmptyString("  Type (cow, chicken, sheep, pig): ");
            type = type.toLowerCase();
            if (type.equals("cow") || type.equals("chicken") || type.equals("sheep") || type.equals("pig")) {
                break;
            } else {
                AppLogger.getInstance().logInfo("Invalid input. Please enter 'cow', 'chicken', 'sheep', or 'pig'.");
            }
        }

        Animal animal = new AnimalFactory().create(type);

        int takesPlaces = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Takes Places: ");
                takesPlaces = Integer.parseInt(scanner.nextLine().trim());
                if (takesPlaces > 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Takes Places must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        int dailyFoodIntake = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Daily Food Intake: ");
                dailyFoodIntake = Integer.parseInt(scanner.nextLine().trim());
                if (dailyFoodIntake > 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Daily Food Intake must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        animal.setType(type);
        return animal;
    }

    private Product readProduct() {
        AppLogger.getInstance().logInfo("Enter product data:");

        ProductType productType = null;
        while (productType == null) {
            AppLogger.getInstance().logInfo("  Select Product Type:");
            for (ProductType type : ProductType.values()) {
                AppLogger.getInstance().logInfo("    - " + type.name() + " (" + type.getDisplayName() + ")");
            }

            String typeInput = readNonEmptyString("  Type: ").toUpperCase();

            try {
                productType = ProductType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                AppLogger.getInstance().logError("Invalid product type. Please choose a valid type from the list.");
            }
        }

        String name = readNonEmptyString("  Product Name: ");
        double price = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Price: ");
                price = Double.parseDouble(scanner.nextLine().trim());
                if (price >= 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Price must be a non-negative number.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid price format. Please enter a valid number.");
            }
        }

        int weight = 0;
        while (true) {
            try {
                AppLogger.getInstance().logInfo("  Weight: ");
                weight = Integer.parseInt(scanner.nextLine().trim());
                if (weight > 0) {
                    break;
                } else {
                    AppLogger.getInstance().logWarning("Weight must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                AppLogger.getInstance().logError("Invalid number format. Please enter a valid integer.");
            }
        }

        return new ProductFactory().createProduct(productType.toString(), name, price, weight);
    }



}
