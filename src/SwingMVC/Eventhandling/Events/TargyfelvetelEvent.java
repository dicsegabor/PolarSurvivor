package SwingMVC.Eventhandling.Events;

import Mozgathato.Karakter;
import Targy.Targy;

import java.util.EventObject;

public class TargyfelvetelEvent extends EventObject {

    public Targy felvettTargy;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TargyfelvetelEvent(Karakter source, Targy targy) {

        super(source);
        felvettTargy = targy;
    }
}
