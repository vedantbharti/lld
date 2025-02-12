package commonDesignPatterns.observer.observable;

import commonDesignPatterns.observer.observer.Observer;

public interface Observable {

    public void subscribe(Observer observer);

    public void unsubscribe(Observer observer);

    public void notifySubscribers();

}
