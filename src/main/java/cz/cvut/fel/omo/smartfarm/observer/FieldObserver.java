package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.state.field.*;

public class FieldObserver extends Observer<FieldState> {


    public FieldObserver(Subject<FieldState> subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();

        switch (state) {
            case FreeState free -> System.out.println("The field is free and ready for use.");
            case PlantedState planted -> System.out.println("The field is planted and crops are growing.");
            case ReadyToHarvestState ready -> System.out.println("The field is ready for harvesting.");
            case PesticideAppliedState pesticide -> System.out.println("The field has been treated with pesticides.");
            default -> System.out.println("The field is in an unknown or unsupported state.");
        }
    }



}
