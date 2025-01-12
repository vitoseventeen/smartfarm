package cz.cvut.fel.omo.smartfarm.state.farmer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;
import cz.cvut.fel.omo.smartfarm.model.farmer.Farmer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;


public class FarmerStateTest {

    @Mock
    private Farmer farmer;

    private MockedStatic<AppLogger> mockLoggerStatic;

    @BeforeEach
    public void setUp() {
        mockLoggerStatic = mockStatic(AppLogger.class);

        AppLogger mockLogger = mock(AppLogger.class);
        when(AppLogger.getInstance()).thenReturn(mockLogger);

        farmer = new Farmer("John", 21, new SleepingState());
    }

    @Test
    public void testWorkFromSleepingState() {
        AppLogger mockLogger = AppLogger.getInstance();

        farmer.work();

        verify(mockLogger).logInfo("John is waking up and starting to work.");
    }

    @Test
    public void testRestFromSleepingState() {
        AppLogger mockLogger = AppLogger.getInstance();

        farmer.rest();

        verify(mockLogger).logInfo("John cannot rest while sleeping.");
    }

    @Test
    public void testSleepFromSleepingState() {
        AppLogger mockLogger = AppLogger.getInstance();

        farmer.sleep();

        verify(mockLogger).logInfo("John is already sleeping.");
    }

    @Test
    public void testWorkFromRestingState() {
        farmer.setState(new RestingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.work();

        verify(mockLogger).logInfo("John feels rested and starts working.");
    }

    @Test
    public void testRestFromRestingState() {
        farmer.setState(new RestingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.rest();

        verify(mockLogger).logInfo("John is already resting.");
    }

    @Test
    public void testSleepFromRestingState() {
        farmer.setState(new RestingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.sleep();

        verify(mockLogger).logInfo("John goes to sleep after resting.");
    }

    @Test
    public void testWorkFromWorkingState() {
        farmer.setState(new WorkingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.work();

        verify(mockLogger).logInfo("John is already working.");
    }

    @Test
    public void testRestFromWorkingState() {
        farmer.setState(new WorkingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.rest();

        verify(mockLogger).logInfo("John is taking a rest after working.");
    }

    @Test
    public void testSleepFromWorkingState() {
        farmer.setState(new WorkingState());

        AppLogger mockLogger = AppLogger.getInstance();

        farmer.sleep();

        verify(mockLogger).logInfo("John is too tired from working and goes to sleep.");
    }

    @AfterEach
    public void tearDown() {
        mockLoggerStatic.close();
    }
}
