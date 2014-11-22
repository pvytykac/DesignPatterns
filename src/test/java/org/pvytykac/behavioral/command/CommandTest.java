package org.pvytykac.behavioral.command;

import org.junit.Test;

public class CommandTest {

    @Test
    public void commandTest(){
        RemoteControl rc = createRemoteControl();

        rc.undo();

        // turn the light on, turn it back off, undo, undo
        rc.onButtonPushed(0);
        rc.offButtonPushed(0);
        rc.undo();
        rc.undo();

        // open garage door, try to open it again, undo
        rc.onButtonPushed(1);
        rc.onButtonPushed(1);
        rc.undo();

        // turn the fan on, speed it up 3 times, undo 4 times
        rc.onButtonPushed(2);
        rc.onButtonPushed(2);
        rc.onButtonPushed(2);
        rc.onButtonPushed(2);
        rc.undo();
        rc.undo();
        rc.undo();
        rc.undo();
    }

    public RemoteControl createRemoteControl(){
        final Light light = new Light();
        final CeilingFan ceilingFan = new CeilingFan();
        final GarageDoor garageDoor = new GarageDoor();

        RemoteControl rc = new RemoteControl();
        rc.setCommand(0, new LightOnCommand(light), new LightOffCommand(light));
        rc.setCommand(1, new GarageDoorOpenCommand(garageDoor), new GarageDoorCloseCommand(garageDoor));
        rc.setCommand(2, new CeilingFanOnCommand(ceilingFan), new CeilingFanOffCommand(ceilingFan));

        return rc;
    }

}
