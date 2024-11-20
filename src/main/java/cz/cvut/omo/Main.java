package cz.cvut.omo;

import cz.cvut.omo.model.*;
import cz.cvut.omo.model.animal.Animal;
import cz.cvut.omo.model.build.Building;
import cz.cvut.omo.model.equipment.EquipmentStatus;
import cz.cvut.omo.model.equipment.Machine;
import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.farmer.FarmerStatus;
import cz.cvut.omo.model.field.Field;
import cz.cvut.omo.model.field.FieldStatus;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        // Test configuration
//        Farmer farmer = new Farmer("John", 32, FarmerStatus.RESTING);
//        Field field = new Field("Corn Field", 10, FieldStatus.FREE);
//        Machine tractor = new Machine("Tractor", "John Deere", EquipmentStatus.OFF, 0);
//        Animal cow = new Animal("Cow", 3);
//        Building barn = new Building("Main barn", 100, "Barn");
//        Farm farm = new Farm("John's farm",List.of(field), List.of(farmer), List.of(barn), List.of(tractor), List.of(cow));
//
//        System.out.println(farm);
//
//        farmer.plantCrops(field, "Corn");
//        farmer.applyPesticide(field);
//        farmer.harvestCrops(field);
//
//        farmer.refuelMachine(tractor, 100);
//        farmer.startMachine(tractor);
//        farmer.stopMachine(tractor);
//
//        tractor.setStatus(EquipmentStatus.BROKEN);
//        farmer.repairMachine(tractor);
    }
}