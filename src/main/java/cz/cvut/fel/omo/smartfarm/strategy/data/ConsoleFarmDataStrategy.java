package cz.cvut.fel.omo.smartfarm.strategy.data;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
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
        System.out.print("Enter farm name: ");
        String name = scanner.nextLine();

        List<Field> fields = readList("field", this::readField);
        List<Farmer> farmers = readList("farmer", this::readFarmer);
        List<Building> buildings = readList("building", this::readBuilding);

        FarmBuilder builder = new FarmBuilder()
                .setName(name)
                .addFields(fields)
                .addFarmers(farmers)
                .addBuildings(buildings);

        return Optional.ofNullable(builder.build());
    }


    private <T> List<T> readList(String itemType, Supplier<T> reader) {
        List<T> list = new ArrayList<>();
        while (true) {
            System.out.print("Do you want to add a " + itemType + "? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(answer)) {
                list.add(reader.get());
            } else if ("no".equals(answer)) {
                break;
            } else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
        return list;
    }

    private String readNonEmptyString(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
        return input;
    }

    private Field readField() {
        System.out.println("Enter field data:");
        String cropType = readNonEmptyString("  Crop type: ");
        int fieldSize = 0;

        while (true) {
            try {
                System.out.print("  Field size: ");
                fieldSize = Integer.parseInt(scanner.nextLine().trim());
                if (fieldSize > 0) {
                    break;
                } else {
                    System.out.println("Field size must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid integer.");
            }
        }

        return new Field(cropType, fieldSize);
    }

    private Farmer readFarmer() {
        System.out.println("Enter farmer data:");
        String name = readNonEmptyString("  Name: ");
        int age = 0;

        while (true) {
            try {
                System.out.print("  Age: ");
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age > 0 && age < 120) {
                    break;
                } else {
                    System.out.println("Age must be a correct. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid integer.");
            }
        }

        return new Farmer(name, age, new WorkingState());
    }

    private Building readBuilding() {
        System.out.println("Enter building data:");
        String name = readNonEmptyString("  Name: ");
        int capacity = 0;

        // Запросим и проверим корректность ввода для емкости
        while (true) {
            try {
                System.out.print("  Capacity: ");
                capacity = Integer.parseInt(scanner.nextLine().trim());
                if (capacity > 0) {
                    break;
                } else {
                    System.out.println("Capacity must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid integer.");
            }
        }

        BuildingType type = null;
        while (type == null) {
            System.out.println("  Select Building Type:");
            for (BuildingType buildingType : BuildingType.values()) {
                System.out.println("    - " + buildingType.name() + " (" + buildingType.getDisplayName() + ")");
            }

            String typeInput = readNonEmptyString("  Type: ").toUpperCase();

            try {
                type = BuildingType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid building type. Please choose a valid type from the list.");
            }
        }

        return switch (type) {
            case BARN -> new Barn(name, capacity);
            case STABLE -> new Stable(name, capacity, new ArrayList<>());
            case GREENHOUSE -> new Greenhouse(name, capacity);
            case WAREHOUSE -> new Warehouse(name, capacity);
            case HOUSE -> new House(name, capacity, new ArrayList<>());
            case WORKSHOP -> new Workshop(name, capacity);
            default -> throw new IllegalArgumentException("Unknown building type");
        };
    }
}