package commonDesignPatterns.observer.observer;

import commonDesignPatterns.observer.observable.ItemObservable;

public class SMSObserver implements Observer{

    ItemObservable itemObservable;

    public SMSObserver(ItemObservable itemObservable){
        this.itemObservable = itemObservable;
    }
    @Override
    public void update() {
        System.out.println("SMS: More items added into the stock");
    }
}
