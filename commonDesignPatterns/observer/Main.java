package commonDesignPatterns.observer;

import commonDesignPatterns.observer.observable.ItemObservable;
import commonDesignPatterns.observer.observable.LaptopObservable;
import commonDesignPatterns.observer.observable.Observable;
import commonDesignPatterns.observer.observer.EmailObserver;
import commonDesignPatterns.observer.observer.Observer;
import commonDesignPatterns.observer.observer.SMSObserver;

public class Main {

    public static void main(String[] args) {

        ItemObservable laptopObservable = new LaptopObservable();

        //we have done constructor injection for Observable into observer to avoid checking for a particular
        //instance of the observable in case observer needs any observable data. For the sake of simplicity, we haven't done here.
        Observer emailObserver = new EmailObserver(laptopObservable);
        Observer smsObserver = new SMSObserver(laptopObservable);

        laptopObservable.subscribe(emailObserver);
        laptopObservable.subscribe(smsObserver);

        System.out.println("We should get notification this time: ");
        laptopObservable.addItem(10);
        System.out.println("We should not get notification this time: ");
        laptopObservable.addItem(0);
        System.out.println("We should again get notification this time: ");
        laptopObservable.addItem(1);

    }
}
