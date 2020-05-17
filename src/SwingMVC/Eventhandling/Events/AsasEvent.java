package SwingMVC.Eventhandling.Events;

import java.util.EventObject;

public class AsasEvent extends EventObject {

    public int horeteg;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AsasEvent(Object source, int horeteg) {

        super(source);
        this.horeteg = horeteg;
    }
}
