package cz.cvut.fel.omo.smartfarm.observer;

import cz.cvut.fel.omo.smartfarm.logger.AppLogger;

public abstract class Observer<T> {
    protected Subject<T> subject;

    public Observer(Subject<T> subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update() {
        AppLogger.getInstance().logHint(this.getClass().getSimpleName() + "<" + this.hashCode() + "> update");
    }
}
