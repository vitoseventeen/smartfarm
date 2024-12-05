package cz.cvut.omo.model.equipment;

public class RepairedState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        System.out.println(equipment.getName() + " is repaired and turning ON.");
        equipment.setState(new OnState());
    }

    @Override
    public void turnOff(Equipment equipment) {
        System.out.println(equipment.getName() + " is OFF after repairs.");
        equipment.setState(new OffState());
    }

    @Override
    public void repair(Equipment equipment) {
        System.out.println(equipment.getName() + " is already repaired.");
    }

    @Override
    public void breakDown(Equipment equipment) {
        System.out.println(equipment.getName() + " is breaking down again.");
        equipment.setState(new BrokenState());
    }

    @Override
    public void performAction(Equipment equipment) {
        System.out.println(equipment.getName() + " is repaired and ready to perform actions.");
    }
}