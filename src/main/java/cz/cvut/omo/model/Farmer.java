package cz.cvut.omo.model;

import java.util.List;

public class Farmer {
    private String name;
    private int age;
    private FarmerActionStatus currentAction;

    public Farmer(String name, int age, FarmerActionStatus currentAction) {
        this.name = name;
        this.age = age;
        this.currentAction = currentAction;
    }
    //TODO: добавить в методы проверку наличия ресурсов для выполнения действия

    //begin of methods for farmer actions on field

    public void plantCrops(Field field, String cropType) {
        if (field.getStatus() == FieldStatus.FREE) {
            setCurrentAction(FarmerActionStatus.WORKING);
            field.setCropType(cropType);
            field.setStatus(FieldStatus.PLANTED);
            System.out.println(name + " has planted " + cropType + " on the field.");
        } else {
            System.out.println("Field is not ready for planting.");
        }
        setCurrentAction(FarmerActionStatus.RESTING);
    }

    public void applyPesticide(Field field) {
        if (field.getStatus() == FieldStatus.PLANTED) {
            setCurrentAction(FarmerActionStatus.WORKING);
            field.setStatus(FieldStatus.PESTICIDE_APPLIED);
            System.out.println(name + " has applied pesticide to the field.");
        } else {
            System.out.println("Field is not ready for pesticide application.");
        }
        setCurrentAction(FarmerActionStatus.RESTING);
        field.setStatus(FieldStatus.READY_TO_HARVEST);
    }



    public void harvestCrops(Field field) {
        if (field.getStatus() == FieldStatus.READY_TO_HARVEST) {
            setCurrentAction(FarmerActionStatus.WORKING);
            field.setStatus(FieldStatus.FREE);
            System.out.println(name + " has harvested crops from the field.");
        } else {
            System.out.println("Field is not ready for harvesting.");
        }
        setCurrentAction(FarmerActionStatus.RESTING);
    }


    // end of methods for farmer actions on field

    // begin of methods for farmer actions on machine
    public void startMachine(Machine machine) {
        if (machine.getStatus() == MachineStatus.OFF || machine.getStatus() == MachineStatus.REPAIRED) {
            System.out.println(name + " has started the " + machine.getName() + ".");
            machine.setStatus(MachineStatus.ON);
        } else {
            System.out.println("Cannot start " + machine.getName() + " while it is active.");
        }
    }

    public void stopMachine(Machine tractor) {
        if (tractor.getStatus() == MachineStatus.ON) {
            System.out.println(name + " has stopped the " + tractor.getName() + ".");
            tractor.setStatus(MachineStatus.OFF);
        } else {
            System.out.println("Cannot stop " + tractor.getName() + " while it is not active.");
        }
    }

    public void repairMachine(Machine machine) {
        if (machine.getStatus() == MachineStatus.BROKEN) {
            setCurrentAction(FarmerActionStatus.WORKING);
            machine.setStatus(MachineStatus.REPAIRED);
            System.out.println(name + " is repairing the " + machine.getName() + ".");
        } else {
            System.out.println("Cannot repair " + machine.getName() + " while it is not broken.");
        }
        setCurrentAction(FarmerActionStatus.RESTING);
    }

    public void refuelMachine(Machine machine, int fuelAmount) {
        if (machine.getStatus() == MachineStatus.OFF) {
            setCurrentAction(FarmerActionStatus.WORKING);
            machine.refuel(fuelAmount);
        } else {
            System.out.println("Cannot refuel " + machine.getName() + " while it is active.");
        }
        setCurrentAction(FarmerActionStatus.RESTING);
    }

    // end of methods for farmer actions on machine

    // begin of methods for farmer actions on animals


    // end of methods for farmer actions on animals


    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", currentAction=" + currentAction +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public FarmerActionStatus getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(FarmerActionStatus currentAction) {
        this.currentAction = currentAction;
    }


}
