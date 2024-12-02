
package cz.cvut.omo.model.equipment;

public class BrokenState implements EquipmentState {
    @Override
    public void turnOn(Equipment equipment) {
        System.out.println(equipment.getName() + " is broken and cannot be turned ON.");
    }

    @Override
    public void turnOff(Equipment equipment) {
        System.out.println(equipment.getName() + " is already OFF and broken.");
    }

    @Override
    public void repair(Equipment equipment) {
        System.out.println(equipment.getName() + " is being repaired.");
        equipment.setState(new RepairedState());
    }

    @Override
    public void breakDown(Equipment equipment) {
        System.out.println(equipment.getName() + " is already broken.");
    }

    @Override
    public void performAction(Equipment equipment) {
        System.out.println(equipment.getName() + " is broken and cannot perform any actions.");
    }
}