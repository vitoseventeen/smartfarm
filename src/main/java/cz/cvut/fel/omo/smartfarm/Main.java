package cz.cvut.fel.omo.smartfarm;

import cz.cvut.fel.omo.smartfarm.builder.FarmBuilder;
import cz.cvut.fel.omo.smartfarm.model.animal.AnimalFactory;
import cz.cvut.fel.omo.smartfarm.model.build.Barn;
import cz.cvut.fel.omo.smartfarm.model.build.House;
import cz.cvut.fel.omo.smartfarm.model.equipment.Machine;
import cz.cvut.fel.omo.smartfarm.model.equipment.Tool;
import cz.cvut.fel.omo.smartfarm.model.farm.Farm;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import cz.cvut.fel.omo.smartfarm.model.field.Field;
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
        FarmBuilder farmBuilder = new FarmBuilder();

        Farm farm = farmBuilder
                .setName("Green Valley Farm")
                .addFarmer(new Farmer("John", 34, new RestingState(), List.of()))
                .addField(new Field("Wheat field", 100))
                .addBuilding(new Barn("Barn", 100))
                .addBuilding(new House("House", 100, List.of(new Farmer("Jane", 30, new RestingState(), List.of())))
                )
                .addAnimal(AnimalFactory.createAnimal("Cow",4))
                .addAnimal(AnimalFactory.createAnimal("Chicken",2))
                .addAnimal(AnimalFactory.createAnimal("Pig",3))
                .addEquipment(new Machine("Tractor", 100))
                .addEquipment(new Tool("Drill", "Electric"))
                .build();

        System.out.println(farm);


        // Observer
        Subject<EquipmentState> subject = new Subject<>(new OnState());

        new EquipmentObserver(subject);
        new EquipmentObserver(subject);
        new EquipmentObserver(subject);

        subject.setState(new OffState());
        subject.setState(new OnState());
        subject.setState(new BrokenState());


    }
}