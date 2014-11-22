package org.pvytykac.behavioral.command;

import java.util.Stack;

public class CeilingFanOnCommand implements Command {

    private CeilingFan ceilingFan;
    private Stack<Boolean> boolStack = new Stack<>();

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        boolStack.push(ceilingFan.isOn());
        if(ceilingFan.isOn()){
            ceilingFan.incrementRpm();
        }else{
            ceilingFan.on();
        }
    }

    @Override
    public void undo() {
        boolean wasOn = boolStack.pop();
        if(wasOn){
            ceilingFan.decrementRpm();
        }else{
            ceilingFan.off();
        }
    }
}
