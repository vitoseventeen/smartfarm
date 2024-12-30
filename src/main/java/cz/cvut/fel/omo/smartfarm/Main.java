package cz.cvut.fel.omo.smartfarm;

import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.*;
import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.equipment.Equipment;
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
    private final static int EVENT_COUNT = 100;
    private final static int DELAY = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FarmDataStrategy farmDataStrategy;

        AppLogger logger =  setUpAppLogger();

        farmDataStrategy = loadFarmDataFromJson(scanner);

        Subject<EquipmentState> equipmentSubject = new Subject<>(new OnState());
        Subject<FarmerState> farmerSubject = new Subject<>(new RestingState());
        Subject<FieldState> fieldSubject = new Subject<>(new FreeState());

        Optional<Farm> optionalFarm = farmDataStrategy.read();
        Farm farm;

        if (optionalFarm.isPresent()) {
            farm = optionalFarm.get();
            logger.logHint("Farm created successfully: ");
            logger.logHint(farm.toString());
            simulateDelay();

        } else {
            logger.logError("Farm created Failed");
            throw new RuntimeException("Failed to create farm.");
        }

        logger.logHint("Farm name: " + farm.getName());

        if (!farm.getEquipments().isEmpty()) {
            new EquipmentObserver(equipmentSubject);
        }
        if (!farm.getFarmers().isEmpty()) {
            new FarmerObserver(farmerSubject);
        }
        if (!farm.getFields().isEmpty()) {
            new FieldObserver(fieldSubject);
        }

        logger.logHint("Observers have been added to the subjects.");
        simulateDelay();
        EventHandler chainRoot = getEventHandler(farm);
        logger.logHint("\nProcessing random events...");
        simulateDelay();
        for (int i = 1; i <= EVENT_COUNT; i++) {
            Event event = createRandomEvent();
            logger.logHint("Event #" + i + "\n" + event);
            assert chainRoot != null;
            chainRoot.handleEvent(event);
            simulateDelay();
        }

        saveFarmData(farm, scanner);
    }

    private static void simulateDelay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            AppLogger.getInstance().logError("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
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

    public static FarmDataStrategy loadFarmDataFromJson(Scanner scanner) {
        String choice;
        AppLogger logger= AppLogger.getInstance();

        while (true) {


            logger.logHint("Would you like to load the farm data from a JSON file? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(choice)) {
                while (true) {
                    logger.logHint("Enter the name of the JSON file (e.g., config_1.json, config_2.json): ");
                    String fileName = scanner.nextLine().trim();

                    String filePath = "src/main/resources/" + fileName;
                    File file = new File(filePath);


                    if (file.exists() && file.isFile()) {
                        return new JsonFarmDataStrategy(filePath);
                    } else {
                        logger.logWarning("File not found. Would you like to try again? (yes/no): ");
                        String tryAgain = scanner.nextLine().trim().toLowerCase();
                        if ("no".equals(tryAgain)) {
                            return new ConsoleFarmDataStrategy();
                        }
                    }
                }
            } else if ("no".equals(choice)) {


                return new ConsoleFarmDataStrategy();
            } else {


                logger.logWarning("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
    }

    public static void saveFarmData(Farm farm, Scanner scanner) {
        String saveChoice;

        AppLogger logger = AppLogger.getInstance();

        while (true) {
            logger.logHint("Would you like to save the current farm data to a JSON file? (yes/no): ");


            saveChoice = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(saveChoice)) {
                String fileName;
                while (true) {


                    logger.logHint("Enter the file name to save (e.g., config_1.json): ");
                    fileName = scanner.nextLine().trim();

                    String filePath = "src/main/resources/" + fileName;
                    File file = new File(filePath);

                    if (file.exists()) {
                        logger.logHint("A file with this name already exists. Would you like to overwrite it? (yes/no): ");
                        String overwriteChoice = scanner.nextLine().trim().toLowerCase();

                        while (!"yes".equals(overwriteChoice) && !"no".equals(overwriteChoice)) {
                            logger.logError("Invalid input. Please answer with 'yes' or 'no'.");
                            overwriteChoice = scanner.nextLine().trim().toLowerCase();
                        }

                        if ("no".equals(overwriteChoice)) {
                            continue;
                        }
                    }

                    JsonFarmDataStrategy saveStrategy = new JsonFarmDataStrategy(filePath);
                    saveStrategy.save(farm);
                    break;
                }
                break;
            } else if ("no".equals(saveChoice)) {
                logger.logInfo("Farm data was not saved.");
                break;
            } else {
                logger.logError("Invalid input. Please answer with 'yes' or 'no'.");
            }
        }
    }

    public static AppLogger setUpAppLogger() {
        AppLogger.setUpAppLogger();
        return AppLogger.getInstance();
    }

}
