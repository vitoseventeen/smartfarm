package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public class DefaultEventHandler extends EventHandler {
    @Override
    public void handleEvent(Event event) {
        AppLogger.getInstance().logInfo("Unhandled event: " + event + " - no handler found");
    }
}
