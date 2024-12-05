package cz.cvut.omo.observer;

public abstract class Observer<T> {
    protected Subject<T> subject;

    public Observer(Subject<T> subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update() {
        System.out.println(this.getClass().getSimpleName() + "<" + this.hashCode() + "> update");
    }
}
