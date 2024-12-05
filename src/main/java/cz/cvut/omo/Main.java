package cz.cvut.omo;

import cz.cvut.omo.observer.EquipmentObserver;
import cz.cvut.omo.observer.Subject;
import cz.cvut.omo.state.equipment.BrokenState;
import cz.cvut.omo.state.equipment.EquipmentState;
import cz.cvut.omo.state.equipment.OffState;
import cz.cvut.omo.state.equipment.OnState;

public class Main {
    public static void main(String[] args) {



        Subject<EquipmentState> subject = new Subject<>(new OnState());

        new EquipmentObserver(subject);
        new EquipmentObserver(subject);
        new EquipmentObserver(subject);

        subject.setState(new OffState());
        subject.setState(new OnState());
        subject.setState(new BrokenState());


    }
}