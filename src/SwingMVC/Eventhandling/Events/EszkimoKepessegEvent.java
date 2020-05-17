package SwingMVC.Eventhandling.Events;

import Mozgathato.Eszkimo;

import java.util.EventObject;

public class EszkimoKepessegEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EszkimoKepessegEvent(Eszkimo source) {

        super(source);
    }
}
