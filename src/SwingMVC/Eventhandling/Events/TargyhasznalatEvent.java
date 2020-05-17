package SwingMVC.Eventhandling.Events;

import java.util.EventObject;

public class TargyhasznalatEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TargyhasznalatEvent(Object source) {
        super(source);
    }
}
