package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

public class DefaultEventHandler extends EventHandler {
    @Override
    public void handleEvent(Event event) {
        System.out.println("Unhandled event: " + event);
    }
}
