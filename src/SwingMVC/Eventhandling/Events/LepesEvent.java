package SwingMVC.Eventhandling.Events;

import Mezo.Mezo;
import Mozgathato.Mozgathato;

import java.util.EventObject;

public class LepesEvent extends EventObject {

    public Mezo hova;
    public Mezo honnan;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public LepesEvent(Mozgathato source, Mezo hova, Mezo honnan) {

        super(source);
        this.honnan = honnan;
        this.hova = hova;
    }
}
