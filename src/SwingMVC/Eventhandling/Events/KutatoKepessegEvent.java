package SwingMVC.Eventhandling.Events;

import Mezo.Mezo;
import Mozgathato.Kutato;
import SwingMVC.Controller.Controller;

import java.util.EventObject;

public class KutatoKepessegEvent extends EventObject {

    public Mezo celpont;
    public String kapacitas;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public KutatoKepessegEvent(Kutato source, Mezo celpont, String kapacitas) {

        super(source);
        this.celpont = celpont;
        this.kapacitas = kapacitas;
    }
}
