package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Handles events that do not match any specific handler in the chain of responsibility.
 * Logs unhandled events using the application's logger.
 */
public class DefaultEventHandler extends EventHandler {

    /**
     * Handles an event when no specific handler is available.
     * Logs the event as unhandled.
     *
     * @param event The event to handle.
     */
    @Override
    public void handleEvent(Event event) {
        AppLogger.getInstance().logInfo("Unhandled event: " + event + " - no handler found");
    }
}
