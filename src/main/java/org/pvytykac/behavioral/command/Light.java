package org.pvytykac.behavioral.command;

public class Light {

    private boolean on = false;

    public void on(){
        if(!on){
            this.on = true;
            System.out.println("The light is now on.");
        }else
            System.out.println("The light is already on.");
    }

    public void off(){
        if(on){
            this.on = false;
            System.out.println("The light is now off.");
        }else
            System.out.println("The light is already off.");
    }
}
