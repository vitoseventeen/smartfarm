package cz.cvut.fel.omo.smartfarm;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.chainOfResponsibility.*;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;
import cz.cvut.fel.omo.smartfarm.model.build.Barn;
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

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем ферму
        FarmBuilder farmBuilder = new FarmBuilder();

        Farm farm = farmBuilder
                .setName("Green Valley Farm")
                .addFarmer(new Farmer("John", 34, new RestingState()))
                .addField(new Field("Wheat field", 100))
                .addBuilding(new Barn("Barn", 100))
                .addBuilding(new House("House", 100, List.of(new Farmer("Jane", 30, new RestingState()))))
                .addAnimal(AnimalFactory.createAnimal("Cow"))
                .addAnimal(AnimalFactory.createAnimal("Chicken"))
                .addAnimal(AnimalFactory.createAnimal("Pig"))
                .addAnimal(AnimalFactory.createAnimal("Sheep"))
                .addEquipment(new Machine("Tractor", 100))
                .addEquipment(new Tool("Drill", "Electric"))
                .addProduct(new Milk("Milk", 5, 2))
                .addProduct(new Meat("Meat", 10, 5))
                .addProduct(new Wool("Wool", 3, 1))
                .addProduct(new Egg("Egg", 1, 1))
                .build();

        System.out.println(farm);

        Subject<EquipmentState> subject = new Subject<>(new OnState());

        new EquipmentObserver(subject);
        new EquipmentObserver(subject);
        new EquipmentObserver(subject);

        subject.setState(new OffState());
        subject.setState(new OnState());
        subject.setState(new BrokenState());


        EventHandler chainRoot = getEventHandler(farm);

        List<Event> randomEvents = Event.createRandomEvents(5);

        System.out.println("\nProcessing random events...");


        for (Event event : randomEvents) {
            System.out.println("Generated Event: " + event);
            chainRoot.handleEvent(event);
        }

    }

    private static EventHandler getEventHandler(Farm farm) {
        Farmer farmer = farm.getFarmers().getFirst();
        Field field = farm.getFields().getFirst();
        Machine tractor = (Machine) farm.getEquipments().getFirst();

        FarmerEventHandler farmerHandler = new FarmerEventHandler(farmer);
        FieldEventHandler fieldHandler = new FieldEventHandler(field);
        EquipmentEventHandler equipmentHandler = new EquipmentEventHandler(tractor);
        DefaultEventHandler defaultHandler = new DefaultEventHandler();

        farmerHandler.setNextHandler(fieldHandler);
        fieldHandler.setNextHandler(equipmentHandler);
        equipmentHandler.setNextHandler(defaultHandler);

        EventHandler chainRoot = farmerHandler;
        return chainRoot;
    }
}
