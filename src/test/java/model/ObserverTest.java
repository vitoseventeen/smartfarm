package model;

import cz.cvut.fel.omo.smartfarm.observer.EquipmentObserver;
import cz.cvut.fel.omo.smartfarm.observer.FarmerObserver;
import cz.cvut.fel.omo.smartfarm.observer.FieldObserver;
import cz.cvut.fel.omo.smartfarm.observer.Subject;
import cz.cvut.fel.omo.smartfarm.state.equipment.BrokenState;
import cz.cvut.fel.omo.smartfarm.state.equipment.EquipmentState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OffState;
import cz.cvut.fel.omo.smartfarm.state.equipment.OnState;
import cz.cvut.fel.omo.smartfarm.state.farmer.FarmerState;
import cz.cvut.fel.omo.smartfarm.state.farmer.RestingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.SleepingState;
import cz.cvut.fel.omo.smartfarm.state.farmer.WorkingState;
import cz.cvut.fel.omo.smartfarm.state.field.FieldState;
import cz.cvut.fel.omo.smartfarm.state.field.FreeState;
import cz.cvut.fel.omo.smartfarm.state.field.PlantedState;
import cz.cvut.fel.omo.smartfarm.state.field.ReadyToHarvestState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    void testFieldObserverUpdatesOnStateChange() {
        FieldState initialState = new FreeState();
        Subject<FieldState> fieldSubject = new Subject<>(initialState);
        FieldObserver fieldObserver = new FieldObserver(fieldSubject);

        fieldSubject.setState(new PlantedState());
        fieldSubject.setState(new ReadyToHarvestState());

        assertEquals(ReadyToHarvestState.class, fieldSubject.getState().getClass(),
                "The FieldState should be updated to ReadyToHarvestState.");
    }

    @Test
    void testEquipmentObserverUpdatesOnStateChange() {
        EquipmentState initialState = new OffState();
        Subject<EquipmentState> equipmentSubject = new Subject<>(initialState);
        EquipmentObserver equipmentObserver = new EquipmentObserver(equipmentSubject);

        equipmentSubject.setState(new OnState());
        equipmentSubject.setState(new BrokenState());

        assertEquals(BrokenState.class, equipmentSubject.getState().getClass(),
                "The EquipmentState should be updated to BrokenState.");
    }

    @Test
    void testFarmerObserverUpdatesOnStateChange() {
        FarmerState initialState = new RestingState();
        Subject<FarmerState> farmerSubject = new Subject<>(initialState);
        FarmerObserver farmerObserver = new FarmerObserver(farmerSubject);

        farmerSubject.setState(new WorkingState());
        farmerSubject.setState(new SleepingState());

        assertEquals(SleepingState.class, farmerSubject.getState().getClass(),
                "The FarmerState should be updated to SleepingState.");
    }

    @Test
    void testMultipleObserversRespondToStateChange() {
        EquipmentState initialState = new OffState();
        Subject<EquipmentState> equipmentSubject = new Subject<>(initialState);
        EquipmentObserver observer1 = new EquipmentObserver(equipmentSubject);
        EquipmentObserver observer2 = new EquipmentObserver(equipmentSubject);

        equipmentSubject.setState(new OnState());

        assertEquals(OnState.class, equipmentSubject.getState().getClass(),
                "The EquipmentState should be updated to OnState.");
        // Implicitly verifying the observers respond, as the `update` method logs to the console.
    }

    @Test
    void testObserverDoesNotUpdateOnNullStateChange() {
        EquipmentState initialState = new OffState();
        Subject<EquipmentState> equipmentSubject = new Subject<>(initialState);
        EquipmentObserver equipmentObserver = new EquipmentObserver(equipmentSubject);

        equipmentSubject.setState(null); // Attempt to set a null state

        // Assert
        assertEquals(OffState.class, equipmentSubject.getState().getClass(),
                "The EquipmentState should remain OffState when a null state is attempted.");
    }
}
