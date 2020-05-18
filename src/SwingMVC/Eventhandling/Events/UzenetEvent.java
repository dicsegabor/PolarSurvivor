package SwingMVC.Eventhandling.Events;

import java.util.EventObject;

public class UzenetEvent extends EventObject {

    public String uzenet;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public UzenetEvent(Object source, String uzenet) {

        super(source);
        this.uzenet = uzenet;
    }
}
