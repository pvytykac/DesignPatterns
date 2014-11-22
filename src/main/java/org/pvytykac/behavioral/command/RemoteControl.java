package org.pvytykac.behavioral.command;

import java.util.Stack;

public class RemoteControl {

    public Command[][] arrCommand;
    private Stack<Command> stackUndo = new Stack<>();

    public RemoteControl() {
        arrCommand = new Command[3][2];
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        if(slot > arrCommand.length - 1)
            throw new IllegalArgumentException(
                    "illegal slot index: " + slot + ", valid indexes: " + 0 + " - " + arrCommand.length);

        arrCommand[slot][0] = onCommand;
        arrCommand[slot][1] = offCommand;
    }

    public void onButtonPushed(int slot){
        buttonPushed(slot, 0);
    }

    public void offButtonPushed(int slot){
        buttonPushed(slot, 1);
    }

    private void buttonPushed(int slot, int ix){
        if(slot >= arrCommand.length)
            throw new IllegalArgumentException(
                    "illegal slot index: " + slot + ", valid indexes: " + 0 + " - " + arrCommand.length);

        if(ix >= arrCommand[slot].length)
            throw new IllegalArgumentException(
                    "illegal button index: " + ix + ", valid indexes: " + 0 + " - " + arrCommand[slot].length);

        Command c = arrCommand[slot][ix];
        if(c != null){
            c.execute();
            stackUndo.push(c);
        }
    }

    public void undo(){
        if(!stackUndo.isEmpty()){
            stackUndo.pop().undo();
            System.out.println("The previous command has been undone.");
        }else
            System.out.println("There are no commands to undo currently.");
    }
}
