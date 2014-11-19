package org.pvytykac.behavioral.observer;

import org.junit.Test;

import java.util.Random;

public class ObserverTest {

    @Test
    public void observerTest(){
        WeatherBalloon balloon = new WeatherBalloon();
        balloon.registerObserver(new HighwayTrafficSign());
        balloon.registerObserver(new WeatherStation());

        MeasuringDevice hygrometer = new MeasuringDevice(0.49D, 0.01D);
        MeasuringDevice thermometer = new MeasuringDevice(24.5D, 0.5D);

        for(int i = 0; i < 15; i++){
            double humidity = hygrometer.doMeasurment();
            double temperature = thermometer.doMeasurment();

            balloon.set(temperature, humidity);
        }
    }

    private class MeasuringDevice {

        private double previousValue;
        private final double increment;
        private Random random = new Random();

        private MeasuringDevice(double value, double increment) {
            this.previousValue = value;
            this.increment = increment;
        }

        private double doMeasurment(){
            double roll = random.nextDouble();
            if(roll <= 0.15D)
                previousValue += increment;
            else if(roll > 0.85D)
                previousValue += increment;

            return previousValue;
        }

    }

}
