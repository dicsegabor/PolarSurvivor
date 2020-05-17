package SwingMVC.Controller;

import Mezo.Mezo;
import Mozgathato.Karakter;
import SwingMVC.Eventhandling.Eventhandlers.AtfordulasEventListener;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;
import SwingMVC.Model.Model;

import javax.swing.event.EventListenerList;

public class Controller {

    private static Controller instance;
    private Model model;
    private Karakter activeKarakter;

    private EventListenerList listenerList;

    public static Controller getInstance() {

        if(instance == null)
            return new Controller();

        return instance;
    }

    public Controller(){

        instance = this;

        listenerList = new EventListenerList();
        model = new Model();
        activeKarakter = model.getKarakter(0);
    }

    public void lep(Mezo mezo){

        model.leptet(activeKarakter, mezo);
    }

    //EventHandling
    public void addListener(AtfordulasEventListener listener){

        listenerList.add(AtfordulasEventListener.class, listener);
    }

    public void removeListener(AtfordulasEventListener listener){

        listenerList.remove(AtfordulasEventListener.class, listener);
    }

    public void fireEvent(AtfordulasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == AtfordulasEventListener.class)
                ((AtfordulasEventListener)listeners[i + 1]).atfordult(eventObject);
        }
    }
}
