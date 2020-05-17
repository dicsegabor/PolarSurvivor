package SwingMVC.Eventhandling.Events;

import Mezo.Mezo;

import java.util.EventObject;

public class LepesEvent extends EventObject {

    public Mezo mezo;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public LepesEvent(Object source, Mezo hova) {

        super(source);
        this.mezo = hova;
    }
}
