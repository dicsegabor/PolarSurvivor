package SwingMVC.Eventhandling.Events;

import java.util.EventObject;

public class KarakterKorvegeEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public KarakterKorvegeEvent(Object source) {
        super(source);
    }
}
