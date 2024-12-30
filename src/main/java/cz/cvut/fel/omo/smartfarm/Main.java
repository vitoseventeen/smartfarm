package cz.cvut.fel.omo.smartfarm;

import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.*;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.observer.EquipmentObserver;
import cz.cvut.fel.omo.smartfarm.observer.FarmerObserver;
import cz.cvut.fel.omo.smartfarm.observer.FieldObserver;
import cz.cvut.fel.omo.smartfarm.observer.Subject;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;
import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;
import cz.cvut.fel.omo.smartfarm.state.field.FieldState;
import cz.cvut.fel.omo.smartfarm.state.field.FreeState;
import cz.cvut.fel.omo.smartfarm.strategy.data.ConsoleFarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.FarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.JsonFarmDataStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static cz.cvut.fel.omo.smartfarm.chainOfResponsibility.Event.createRandomEvent;

public class Main {
    private final static int EVENT_COUNT = 10;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FarmDataStrategy farmDataStrategy;

        // Call the method to handle JSON file loading or fallback to manual input
        farmDataStrategy = loadFarmDataFromJson(scanner);

        // Initialize subjects and observers
        Subject<EquipmentState> equipmentSubject = new Subject<>(new OnState());
        Subject<FarmerState> farmerSubject = new Subject<>(new RestingState());
        Subject<FieldState> fieldSubject = new Subject<>(new FreeState());

        Optional<Farm> optionalFarm = farmDataStrategy.read();
        Farm farm;

        if (optionalFarm.isPresent()) {
            farm = optionalFarm.get();
            System.out.println("Farm created successfully: ");
            System.out.println(farm);
        } else {
            throw new RuntimeException("Failed to create farm.");
        }

        System.out.println("Farm name: " + farm.getName());

        // Добавляем наблюдателей только если соответствующие объекты есть
        if (!farm.getEquipments().isEmpty()) {
            new EquipmentObserver(equipmentSubject);
        }
        if (!farm.getFarmers().isEmpty()) {
            new FarmerObserver(farmerSubject);
        }
        if (!farm.getFields().isEmpty()) {
            new FieldObserver(fieldSubject);
        }

        System.out.println("Observers have been added to the subjects.");

        // Chain of Responsibility pattern
        EventHandler chainRoot = getEventHandler(farm);
        System.out.println("\nProcessing random events...");
        for (int i = 1; i <= EVENT_COUNT; i++) {
            Event event = createRandomEvent();
            System.out.println("Event #" + i + "\n" + event);
            assert chainRoot != null;
            chainRoot.handleEvent(event);
        }

    }

    private static EventHandler getEventHandler(Farm farm) {
        List<EventHandler> handlers = new ArrayList<>();

        if (!farm.getFarmers().isEmpty()) {
            for (Farmer farmer : farm.getFarmers()) {
                handlers.add(new FarmerEventHandler(farmer));
            }
        }

        if (!farm.getEquipments().isEmpty()) {
            for (Equipment equipment : farm.getEquipments()) {
                handlers.add(new EquipmentEventHandler(equipment));
            }
        }

        if (!farm.getFields().isEmpty()) {
            for (Field field : farm.getFields()) {
                handlers.add(new FieldEventHandler(field));
            }
        }

        if (handlers.isEmpty()) {
            handlers.add(new DefaultEventHandler());
        }

        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNextHandler(handlers.get(i + 1));
        }

        return handlers.isEmpty() ? null : handlers.get(0);
    }


    // Method to load farm data from a JSON file or fallback to manual input
    public static FarmDataStrategy loadFarmDataFromJson(Scanner scanner) {
        String choice;
        while (true) {
            System.out.println("Would you like to load the farm data from a JSON file? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(choice)) {
                while (true) {
                    System.out.print("Enter the name of the JSON file (e.g., config_1.json, config_2.json): ");
                    String fileName = scanner.nextLine().trim();

                    String filePath = "src/main/resources/" + fileName;
                    File file = new File(filePath);

                    if (file.exists() && file.isFile()) {
                        return new JsonFarmDataStrategy(filePath);
                    } else {
                        System.out.println("File not found. Would you like to try again? (yes/no): ");
                        String tryAgain = scanner.nextLine().trim().toLowerCase();
                        if ("no".equals(tryAgain)) {
                            return new ConsoleFarmDataStrategy(); // Fall back to manual input
                        }
                    }
                }
            } else if ("no".equals(choice)) {
                return new ConsoleFarmDataStrategy(); // Fall back to manual input
            } else {
                System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
    }
}
