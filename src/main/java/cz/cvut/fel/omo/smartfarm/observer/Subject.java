package cz.cvut.fel.omo.smartfarm.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a subject in the observer pattern.
 * The subject maintains a state and notifies registered observers whenever the state changes.
 *
 * @param <T> The type of the state being observed.
 */
public class Subject<T> {
    private final List<Observer<T>> observers = new ArrayList<>();
    private T state;

    /**
     * Constructs a Subject with an initial state.
     *
     * @param state The initial state of the subject.
     */
    public Subject(T state) {
        this.state = state;
    }

    /**
     * Returns the current state of the subject.
     *
     * @return The current state.
     */
    public T getState() {
        return state;
    }

    /**
     * Updates the state of the subject and notifies all registered observers.
     *
     * @param state The new state to be set.
     *              If the state is not null, all observers will be notified.
     */
    public void setState(T state) {
        if (state != null) {
            this.state = state;
            notifyObservers();
        }
    }

    /**
     * Registers a new observer to be notified of state changes.
     *
     * @param observer The observer to add.
     */
    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers of a state change.
     * Each observer's {@code update} method is called.
     */
    private void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update();
        }
    }
}
