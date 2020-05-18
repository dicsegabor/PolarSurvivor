package SwingMVC.Eventhandling.Events;

import Epulet.Epulet;

import java.util.EventObject;

public class EpitesEvent extends EventObject {

    public Epulet epulet;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EpitesEvent(Object source, Epulet epulet) {

        super(source);
        this.epulet = epulet;
    }
}
