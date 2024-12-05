package cz.cvut.omo.observer;

import cz.cvut.omo.state.equipment.BrokenState;
import cz.cvut.omo.state.equipment.EquipmentState;
import cz.cvut.omo.state.equipment.OffState;
import cz.cvut.omo.state.equipment.OnState;

public class EquipmentObserver extends Observer<EquipmentState> {

    public EquipmentObserver(Subject<EquipmentState> subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();

        switch (state) {
            case OnState onState -> System.out.println("Equipment is working!");
            case OffState offState -> System.out.println("Equipment is turned off!");
            case BrokenState brokenState -> System.out.println("Equipment is broken!");
            default -> System.out.println("Unknown equipment state.");
        }
    }



}
