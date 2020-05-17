package SwingMVC.Eventhandling.Events;

import Targy.Targy;

import java.util.EventObject;

public class TargyhasznalatEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TargyhasznalatEvent(Targy source) {

        super(source);
    }
}
