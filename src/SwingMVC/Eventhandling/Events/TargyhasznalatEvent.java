package SwingMVC.Eventhandling.Events;

import Mozgathato.Karakter;
import Targy.Targy;

import java.util.EventObject;

public class TargyhasznalatEvent extends EventObject {

    public Karakter karakter;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TargyhasznalatEvent(Targy source, Karakter karakter) {

        super(source);
        this.karakter = karakter;
    }
}
