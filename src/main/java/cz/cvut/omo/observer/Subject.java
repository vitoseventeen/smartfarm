package cz.cvut.omo.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
    private final List<Observer<T>> observers = new ArrayList<>();
    private T state;

    public Subject(T state) {
        this.state = state;
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        if (state != null) {
            this.state = state;
            notifyObservers();
        }
    }

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update();
        }
    }
}
