package SwingMVC.Eventhandling.Events;

import java.util.EventObject;

public class KorvegeEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public KorvegeEvent(Object source) {
        super(source);
    }
}
