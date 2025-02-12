package commonDesignPatterns.observer.observer;

import commonDesignPatterns.observer.observable.ItemObservable;

public class EmailObserver implements Observer{

    ItemObservable itemObservable;

    public EmailObserver(ItemObservable itemObservable){
        this.itemObservable = itemObservable;
    }
    @Override
    public void update() {
        System.out.println("Email: More items added into the stock");
    }
}
