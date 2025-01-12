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
/**
 * Main class that initializes and runs the smart farm system.
 * It sets up the farm, handles farm data loading and saving, and processes random events
 * based on the farm's components (farmers, equipment, fields).
 */
public class Main {
    private final static int EVENT_COUNT = 100;
    private final static int DELAY = 200;
    /**
     * The entry point of the application. Initializes the smart farm system, processes random events,
     * and handles user interaction for loading and saving farm data.
     *
     * @param args Command-line arguments (not used in this case).
     */
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

    /**
     * Simulates a delay between actions in the program to mimic real-time processing.
     * Used between event handling to simulate processing time.
     */
    private static void simulateDelay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            AppLogger.getInstance().logError("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
    /**
     * Creates and configures a chain of event handlers based on the farm's components (farmers, equipment, fields).
     * The event handler chain processes the events in sequence.
     *
     * @param farm The farm instance that contains the components to be handled.
     * @return The root event handler of the constructed chain.
     */
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
    /**
     * Loads farm data from either a JSON file or a console-based strategy based on user input.
     * Prompts the user to select a data source.
     *
     * @param scanner The scanner instance used for user input.
     * @return The farm data strategy used to load the farm data.
     */
    public static FarmDataStrategy loadFarmDataFromJson(Scanner scanner) {
        String choice;
        AppLogger logger= AppLogger.getInstance();

        while (true) {


            logger.logHint("Would you like to load the farm data from a JSON file? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(choice)) {
                while (true) {
                    logger.logHint("Enter the name of the JSON file (e.g., config_1, config_2): ");
                    String fileName = scanner.nextLine().trim();

                    String filePath = "src/main/resources/" + fileName + ".json";
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

    /**
     * Saves the current state of the farm to a JSON file. The user is prompted to provide a file name and
     * decide if existing files should be overwritten.
     *
     * @param farm    The current farm instance to save.
     * @param scanner The scanner instance used for user input.
     */
    public static void saveFarmData(Farm farm, Scanner scanner) {
        String saveChoice;

        AppLogger logger = AppLogger.getInstance();

        while (true) {
            logger.logHint("Would you like to save the current farm data to a JSON file? (yes/no): ");


            saveChoice = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(saveChoice)) {
                String fileName;
                while (true) {


                    logger.logHint("Enter the file name to save (e.g., config_1): ");
                    fileName = scanner.nextLine().trim();

                    String filePath = "src/main/resources/" + fileName + ".json";
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

    /**
     * Sets up the application logger based on the selected logging strategy.
     *
     * @return The initialized AppLogger instance.
     */
    public static AppLogger setUpAppLogger() {
        AppLogger.setUpAppLogger();
        return AppLogger.getInstance();
    }

}
