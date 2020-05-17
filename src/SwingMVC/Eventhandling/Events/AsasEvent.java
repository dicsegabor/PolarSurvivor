package SwingMVC.Eventhandling.Events;

import Mozgathato.Karakter;

import java.util.EventObject;

public class AsasEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AsasEvent(Karakter source) {

        super(source);
    }
}
