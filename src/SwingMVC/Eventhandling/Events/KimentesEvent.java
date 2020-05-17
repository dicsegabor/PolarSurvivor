package SwingMVC.Eventhandling.Events;

import Mozgathato.Karakter;

import java.util.EventObject;

public class KimentesEvent extends EventObject {

    public Karakter megmento;
    public Karakter megmentett;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public KimentesEvent(Object source, Karakter megmento, Karakter megmentett) {

        super(source);
        this.megmentett = megmentett;
        this.megmento = megmento;
    }
}
