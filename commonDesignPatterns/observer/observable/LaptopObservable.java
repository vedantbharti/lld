package commonDesignPatterns.observer.observable;

import commonDesignPatterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class LaptopObservable implements ItemObservable{

    List<Observer> observers = new ArrayList<>();
    int itemCount = 0;


    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        observers.forEach(observer -> observer.update());
    }

    @Override
    public void addItem(int numItems) {
        int prevCount = itemCount;
        itemCount += numItems;
        if(itemCount>prevCount){
            notifySubscribers();
        }
    }

    @Override
    public int getCount() {
        return itemCount;
    }
}
