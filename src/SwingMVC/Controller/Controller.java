package SwingMVC.Controller;

import Mezo.Mezo;
import Mozgathato.Karakter;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.AsasEvent;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;
import SwingMVC.Eventhandling.Events.LepesEvent;
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

    public Karakter getActiveKarakter() {

        return activeKarakter;
    }

    public void lep(Mezo mezo){

        model.leptet(activeKarakter, mezo);
    }

    //EventHandling
    public void addListener(MezoEventListener listener){

        listenerList.add(MezoEventListener.class, listener);
    }

    public void removeListener(MezoEventListener listener){

        listenerList.remove(MezoEventListener.class, listener);
    }

    public void atfordultEvent(AtfordulasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).atfordult(eventObject);
        }
    }

    public void lepesEvent(LepesEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).leptek(eventObject, activeKarakter);
        }
    }

    public void asasEvent(AsasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).astak(eventObject);
        }
    }
}
