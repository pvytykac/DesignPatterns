package org.pvytykac.behavioral.observer;

public interface Observable {

    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();

    public double getHumidity();
    public double getTemperature();

}
