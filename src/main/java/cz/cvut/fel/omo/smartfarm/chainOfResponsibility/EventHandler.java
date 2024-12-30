package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

public abstract class EventHandler {
    protected EventHandler nextHandler;

    public void setNextHandler(EventHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleEvent(Event event);


}
