package org.pvytykac.behavioral.command;

public class CeilingFan {

    private int rpm = 60;
    private boolean on = false;

    private static final int MAX_RPM = 120;

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("The ceiling fan is now on, rotating at " + rpm + " rpm.");
        }else
            System.out.println("The ceiling fan is already on.");
    }

    public void off(){
        if(on){
            this.on = false;
            System.out.println("The ceiling fan is now off.");
        }else
            System.out.println("The ceiling fan is already off.");
    }

    public boolean isOn() {
        return on;
    }

    public void incrementRpm(){
        rpm += 10;
        rpm %= MAX_RPM;
        System.out.println("Ceiling fan rpm setting changed to " + rpm + " rpm.");
    }

    public void decrementRpm(){
        rpm -= 10;
        if(rpm <= 0)
            rpm = MAX_RPM;
        System.out.println("Ceiling fan rpm setting changed to " + rpm + " rpm.");
    }

}
