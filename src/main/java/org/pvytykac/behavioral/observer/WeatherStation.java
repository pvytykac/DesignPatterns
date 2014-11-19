package org.pvytykac.behavioral.observer;

public class WeatherStation implements Observer {

    @Override
    public void update(Observable observable) {
        System.out.println("New weather measurements: humidity -> "
                + observable.getHumidity()
                + " %, temperature -> "
                + observable.getTemperature() + " °C");
    }
}
