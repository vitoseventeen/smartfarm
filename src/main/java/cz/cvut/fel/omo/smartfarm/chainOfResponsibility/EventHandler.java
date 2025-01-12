package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

/**
 * Abstract class for handling events in a chain of responsibility pattern.
 * This class provides the basic framework for linking handlers and passing events along the chain.
 */
public abstract class EventHandler {
    protected EventHandler nextHandler;

    /**
     * Sets the next handler in the chain of responsibility.
     *
     * @param nextHandler The next EventHandler to set in the chain.
     */
    public void setNextHandler(EventHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * Handles an event. Concrete implementations of this method will define how specific types of events are handled.
     * If the event cannot be handled, it should be passed to the next handler in the chain, if one exists.
     *
     * @param event The event to be handled.
     */
    public abstract void handleEvent(Event event);
}
