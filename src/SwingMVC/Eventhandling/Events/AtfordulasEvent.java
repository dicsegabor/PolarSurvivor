package SwingMVC.Eventhandling.Events;

import Mezo.Mezo;

import java.util.EventObject;

public class AtfordulasEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public AtfordulasEvent(Mezo source) {

        super(source);
    }
}
