package org.pvytykac.behavioral.observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherBalloon implements Observable {

    private Set<Observer> setObserver = new HashSet<Observer>();

    private double humidity;
    private double temperature;

    @Override
    public void registerObserver(Observer observer) {
        setObserver.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        setObserver.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: setObserver)
            observer.update(this);
    }

    @Override
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        if(this.humidity != humidity){
            this.humidity = humidity;
            notifyObservers();
        }
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if(this.temperature != temperature){
            this.temperature = temperature;
            notifyObservers();
        }
    }

    public void set(double temperature, double humidity){
        if(this.temperature != temperature || this.humidity != humidity){
            this.temperature = temperature;
            this.humidity = humidity;
            notifyObservers();
        }
    }
}
