package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

/**
 * Abstract base class for all observers in the smart farm system.
 * Observers monitor changes in a subject's state and respond accordingly.
 *
 * @param <T> The type of state being observed.
 */
public abstract class Observer<T> {
    protected Subject<T> subject;

    /**
     * Constructs an Observer and registers it with the given subject.
     *
     * @param subject The subject that this observer will monitor.
     */
    public Observer(Subject<T> subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    /**
     * Called when the observed subject's state changes.
     * Default implementation logs an update message, but subclasses should override this method to define specific behavior.
     */
    public void update() {
        AppLogger.getInstance().logHint(this.getClass().getSimpleName() + "<" + this.hashCode() + "> update");
    }
}
