package cz.cvut.fel.omo.smartfarm;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;
import cz.cvut.fel.omo.smartfarm.model.build.Barn;
import cz.cvut.fel.omo.smartfarm.model.build.BuildingType;
import cz.cvut.fel.omo.smartfarm.model.build.House;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
import cz.cvut.fel.omo.smartfarm.model.products.Egg;
import cz.cvut.fel.omo.smartfarm.model.products.Meat;
import cz.cvut.fel.omo.smartfarm.model.products.Milk;
import cz.cvut.fel.omo.smartfarm.model.products.Wool;
import cz.cvut.fel.omo.smartfarm.observer.EquipmentObserver;
import cz.cvut.fel.omo.smartfarm.observer.Subject;
import cz.cvut.fel.omo.smartfarm.state.equipment.BrokenState;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.strategy.data.ConsoleFarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.FarmDataStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.data.JsonFarmDataStrategy;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        FarmBuilder farmBuilder = new FarmBuilder();
//
//        Farm farm = farmBuilder
//                .setName("Green Valley Farm")
//                .addFarmer(new Farmer("John", 34, new RestingState(), List.of()))
//                .addField(new Field("Wheat field", 100))
//                .addBuilding(new Barn("Barn", 100))
//                .addBuilding(new House("House", 100, List.of(new Farmer("Jane", 30, new RestingState(), List.of()))))
//                .addAnimal(AnimalFactory.createAnimal("Cow"))
//                .addAnimal(AnimalFactory.createAnimal("Chicken"))
//                .addAnimal(AnimalFactory.createAnimal("Pig"))
//                .addAnimal(AnimalFactory.createAnimal("Sheep"))
//                .addEquipment(new Machine("Tractor", 100))
//                .addEquipment(new Tool("Drill", "Electric"))
//                .addProduct(new Milk("Milk", 5, 2))
//                .addProduct(new Meat("Meat", 10, 5))
//                .addProduct(new Wool("Wool", 3, 1))
//                .addProduct(new Egg("Egg", 1, 1))
//                .build();
//
//        System.out.println(farm);
//        Subject<EquipmentState> subject = new Subject<>(new OnState());
//
//        new EquipmentObserver(subject);
//        new EquipmentObserver(subject);
//        new EquipmentObserver(subject);
//
//        subject.setState(new OffState());
//        subject.setState(new OnState());
//        subject.setState(new BrokenState());
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

        Optional<Farm> optionalFarm = farmDataStrategy.read();

        if (optionalFarm.isPresent()) {
            Farm farm = optionalFarm.get();
            System.out.println("Farm created successfully: ");
            System.out.println(farm);
        } else {
            System.out.println("Failed to create farm.");
        }

        System.out.println("Farm name: " + farmDataStrategy.read().get().getName());
    }
}