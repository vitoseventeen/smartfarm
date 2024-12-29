package cz.cvut.fel.omo.smartfarm;


import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.EquipmentEventHandler;
import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.Event;
import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.FarmerEventHandler;
import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.FieldEventHandler;

import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;

import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;

import cz.cvut.fel.omo.smartfarm.observer.Subject;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;

import cz.cvut.fel.omo.smartfarm.strategy.data.ConsoleFarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.FarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.JsonFarmDataStrategy;

import java.io.File;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        FarmDataStrategy farmDataStrategy;

        System.out.println("Would you like to load the farm data from a JSON file? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();


        if ("yes".equals(choice)) {
            System.out.print("Enter the name of the JSON file (e.g., farm_data.json): ");
            String fileName = scanner.nextLine().trim();

            String filePath = "src/main/resources/" + fileName;

            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                farmDataStrategy = new JsonFarmDataStrategy(filePath);
            } else {
                System.out.println("File not found in resources. Falling back to manual input.");
                farmDataStrategy = new ConsoleFarmDataStrategy();
            }
        } else {
            farmDataStrategy = new ConsoleFarmDataStrategy();
        }

        Subject<EquipmentState> subject = new Subject<>(new OnState());


        Optional<Farm> optionalFarm = farmDataStrategy.read();
        Farm farm;

        if (optionalFarm.isPresent()) {
            farm = optionalFarm.get();
            System.out.println("Farm created successfully: ");
            System.out.println(farm);
        } else {
            throw new RuntimeException("Failed to create farm.");
        }


        System.out.println("Farm name: " + farmDataStrategy.read().get().getName());

        Farmer farmer = farm.getFarmers().get(0);
        Field field = farm.getFields().get(0);
        Machine tractor = (Machine) farm.getEquipments().get(0);

        FarmerEventHandler farmerHandler = new FarmerEventHandler(farmer);
        FieldEventHandler fieldHandler = new FieldEventHandler(field);
        EquipmentEventHandler equipmentHandler = new EquipmentEventHandler(tractor);

        farmerHandler.setNextHandler(fieldHandler);
        fieldHandler.setNextHandler(equipmentHandler);

        List<Event> randomEvents = Event.createRandomEvents(5);

        System.out.println("\nProcessing random events...");
        for (Event event : randomEvents) {
            System.out.println("Generated Event: " + event);
            farmerHandler.handleEvent(event);
            fieldHandler.handleEvent(event);
            equipmentHandler.handleEvent(event);
        }


    }
}
