package cz.cvut.omo.facade;

import cz.cvut.omo.model.Farm;
import cz.cvut.omo.model.animal.Animal;
import cz.cvut.omo.model.equipment.Equipment;
import cz.cvut.omo.model.equipment.Machine;
import cz.cvut.omo.model.farmer.Farmer;
import cz.cvut.omo.model.field.Field;
import cz.cvut.omo.model.task.Task;
import cz.cvut.omo.state.equipment.BrokenState;
import cz.cvut.omo.state.equipment.OffState;
import cz.cvut.omo.state.equipment.OnState;
import cz.cvut.omo.state.farmer.RestingState;
import cz.cvut.omo.state.farmer.WorkingState;
import cz.cvut.omo.state.field.FreeState;
import cz.cvut.omo.state.field.PlantedState;
import cz.cvut.omo.state.field.ReadyToHarvestState;
import cz.cvut.omo.state.task.TaskState;

import java.util.List;

public class FarmFacade {
    private final Farm farm;

    public FarmFacade(Farm farm) {
        this.farm = farm;
    }

    public void assignAllTasksToAllFarmers() {
        List<Farmer> farmers = farm.getFarmers();
        List<Task> tasks = getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks to assign.");
            return;
        }

        int farmerIndex = 0;
        for (Task task : tasks) {
            Farmer farmer = farmers.get(farmerIndex);
            farmer.getTasks().add(task);
            System.out.println("Assigned task '" + task.getDescription() + "' to farmer " + farmer.getName());
            farmerIndex = (farmerIndex + 1) % farmers.size(); // cycle through farmers
        }
    }

    public void performAllTasks() {
        for (Farmer farmer : farm.getFarmers()) {
            List<Task> tasks = farmer.getTasks();
            if (!tasks.isEmpty()) {
                for (Task task : tasks) {
                    // set workingstate to farmer
                    farmer.setState(new WorkingState());

                    System.out.println("Farmer " + farmer.getName() + " is performing task: " + task.getDescription());

                    TaskState state = task.getState();
                    // do every task based on its state
                    doTaskByState(state);
                }
                // clear all tasks
                farmer.getTasks().clear();
                // set farmer state to default
                farmer.setState(new RestingState());
            } else {
                System.out.println("Farmer " + farmer.getName() + " has no tasks to perform.");
            }
        }
    }

    public void doTaskByState(TaskState state) {
        switch (state.getClass().getSimpleName()) {

            case "ApplyingPesticidesState" -> applyPesticidesToAllFields();
            case "CleaningAnimalsState" -> cleaningAllAnimals();
            case "CollectingProductsState" -> collectAllProducts();
            case "FeedingAnimalsState" -> feedAllAnimals();
            case "HarvestingState" -> harvestAllFields();
            case "PlantingState" -> plantAllFields();
            case "RefuelingMachineState" -> refuelAllMachines();
            case "RepairingState" -> repairAllEquipment();

            default -> System.out.println("Unknown task state: " + state.getClass().getSimpleName());
        }
    }

    private void refuelAllMachines() {
        for (Equipment equipment : farm.getEquipments()) {
            if (equipment instanceof Machine machine) {
                if (machine.getState() instanceof BrokenState) {
                    System.out.println("Refueling machine: " + machine.getName());
                    machine.setFuelLevel(100);
                }
            }
        }
    }

    //TODO: IMPLEMENT THIS METHOD
    public void collectAllProducts() {
        System.out.println("Collecting all products");
    }

    //TODO: IMPLEMENT THIS METHOD
    public void cleaningAllAnimals() {
        for (Animal animal : farm.getAnimals()) {
            System.out.println("Cleaning animal: " + animal.getType());
        }
    }

    //TODO: IMPLEMENT THIS METHOD
    public void feedAllAnimals() {
        for (Animal animal : farm.getAnimals()) {
            System.out.println("Feeding animal: " + animal.getType());
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = farm.getFarmers().stream()
                .map(Farmer::getTasks)
                .flatMap(List::stream)
                .toList();
        farm.getFarmers().forEach(farmer -> farmer.getTasks().clear());
        return tasks;
    }

    public void printTasks() {
        for (Farmer farmer : farm.getFarmers()) {
            System.out.println("Tasks for farmer " + farmer.getName() + ":");
            for (Task task : farmer.getTasks()) {
                System.out.println("  - " + task);
            }
        }
    }

    public void plantAllFields() {
        for (Field field : farm.getFields()) {
            if (field.getState() instanceof FreeState) {
                field.plant();
                System.out.println("Field planted: " + field);
                field.setState(new PlantedState());
            } else {
                System.out.println("Field " + field + " is not ready for planting.");
            }
        }
    }

    public void applyPesticidesToAllFields() {
        for (Field field : farm.getFields()) {
            if (field.getState() instanceof PlantedState) {
                field.applyPesticides();
                System.out.println("Pesticides applied to field: " + field);
                field.setState(new ReadyToHarvestState());
            }
        }
    }

    public void harvestAllFields() {
        for (Field field : farm.getFields()) {
            if (field.getState() instanceof ReadyToHarvestState) {
                field.harvest();
                System.out.println("Field harvested: " + field);
                field.setState(new FreeState());
            } else {
                System.out.println("Field " + field + " is not ready for harvest.");
            }
        }
    }

    public void startAllEquipment() {
        for (Equipment equipment : farm.getEquipments()) {
            if (equipment.getState() instanceof OffState) {
                System.out.println("Starting equipment: " + equipment.getName());
                equipment.turnOn();
            }
        }
    }

    public void stopAllEquipment() {
        for (Equipment equipment : farm.getEquipments()) {
            if (equipment.getState() instanceof OnState) {
                System.out.println("Stopping equipment: " + equipment.getName());
                equipment.turnOff();
            }
        }
    }

    public void repairAllEquipment() {
        for (Equipment equipment : farm.getEquipments()) {
            if (equipment.getState() instanceof BrokenState) {
                System.out.println("Repairing equipment: " + equipment.getName());
                equipment.repair();
            }
        }
    }



}
