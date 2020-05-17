package SwingMVC.Eventhandling.Events;

import Mozgathato.Karakter;

import java.util.EventObject;

public class TargyfelvetelEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TargyfelvetelEvent(Karakter source) {

        super(source);
    }
}
