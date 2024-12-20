package cz.cvut.omo;

import cz.cvut.omo.builder.FarmBuilder;
import cz.cvut.omo.model.animal.AnimalFactory;
import cz.cvut.omo.model.build.Barn;
import cz.cvut.omo.model.build.House;
import cz.cvut.omo.model.equipment.Machine;
import cz.cvut.omo.model.equipment.Tool;
import cz.cvut.omo.model.farm.Farm;
import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.field.Field;
import cz.cvut.omo.observer.EquipmentObserver;
import cz.cvut.omo.observer.Subject;
import cz.cvut.omo.state.equipment.BrokenState;
import cz.cvut.omo.state.equipment.EquipmentState;
import cz.cvut.omo.state.equipment.OffState;
import cz.cvut.omo.state.equipment.OnState;
import cz.cvut.omo.state.farmer.RestingState;
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