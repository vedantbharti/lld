package commonDesignPatterns.observer.observable;

import commonDesignPatterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public interface ItemObservable extends Observable{

    public void addItem(int numItems);

    public int getCount();

}
