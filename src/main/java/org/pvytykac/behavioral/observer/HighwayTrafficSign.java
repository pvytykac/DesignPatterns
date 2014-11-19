package org.pvytykac.behavioral.observer;

public class HighwayTrafficSign implements Observer {

    private boolean displayingHumidityWarning = false;

    @Override
    public void update(Observable observable) {
        if(observable.getHumidity() < 0.5D && displayingHumidityWarning){
            displayingHumidityWarning = false;
        }else if(observable.getHumidity() >= 0.5D && !displayingHumidityWarning){
            displayingHumidityWarning = true;
            System.out.println("Caution: humidity > 50%");
        }
    }
}
