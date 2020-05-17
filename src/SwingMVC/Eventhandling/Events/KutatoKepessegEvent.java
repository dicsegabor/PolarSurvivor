package SwingMVC.Eventhandling.Events;

import Mezo.Mezo;
import Mozgathato.Kutato;

import java.util.EventObject;

public class KutatoKepessegEvent extends EventObject {

    public Mezo celpont;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public KutatoKepessegEvent(Kutato source, Mezo celpont) {

        super(source);
        this.celpont = celpont;
    }
}
