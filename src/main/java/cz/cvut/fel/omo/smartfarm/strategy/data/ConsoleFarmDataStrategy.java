package cz.cvut.fel.omo.smartfarm.strategy.data;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.build.*;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Product;
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
            if (!answer.equals("yes")) {
                break;
            }
            list.add(reader.get());
        }
        return list;
    }

    private Field readField() {
        System.out.println("Enter field data:");
        System.out.print("  Crop type: ");
        String cropType = scanner.nextLine();

        System.out.print("  Field size: ");
        int fieldSize = Integer.parseInt(scanner.nextLine());

        return new Field(cropType, fieldSize);
    }

    private Farmer readFarmer() {
        System.out.println("Enter farmer data:");
        System.out.print("  Name: ");
        String name = scanner.nextLine();

        System.out.print("  Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        return new Farmer(name, age, new WorkingState(), new ArrayList<>());
    }

    private Building readBuilding() {
        System.out.println("Enter building data:");
        System.out.print("  Name: ");
        String name = scanner.nextLine();

        System.out.print("  Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        System.out.println("  Select Building Type:");
        for (BuildingType type : BuildingType.values()) {
            System.out.println("    - " + type.name() + " (" + type.getDisplayName() + ")");
        }
        System.out.print("  Type: ");
        String typeInput = scanner.nextLine();
        BuildingType type = BuildingType.valueOf(typeInput.toUpperCase());


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
