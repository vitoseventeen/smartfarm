package cz.cvut.omo.observer;

import cz.cvut.omo.state.farmer.*;

public class FarmerObserver extends Observer<FarmerState> {


    public FarmerObserver(Subject<FarmerState> subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();

        var state = this.subject.getState();

        switch (state) {
            case WorkingState working -> System.out.println("The field is free and ready for use.");
            case SleepingState sleeping -> System.out.println("The field is planted and crops are growing.");
            case RestingState resting -> System.out.println("The field is ready for harvesting.");
            default -> System.out.println("The field is in an unknown or unsupported state.");
        }


    }


}
