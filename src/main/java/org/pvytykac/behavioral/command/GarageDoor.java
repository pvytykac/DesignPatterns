package org.pvytykac.behavioral.command;

public class GarageDoor {

    private boolean opened = false;

    public void open(){
        if(!opened){
            this.opened = true;
            System.out.println("The garage door is now opened.");
        }else
            System.out.println("The garage door is already opened.");
    }

    public void close(){
        if(opened){
            this.opened = false;
            System.out.println("The garage door is now closed.");
        }else
            System.out.println("The garage door is already closed.");
    }

}
