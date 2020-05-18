package SwingMVC.Controller;

import Mezo.Mezo;
import Mozgathato.Eszkimo;
import Mozgathato.Karakter;
import SwingMVC.Eventhandling.Eventhandlers.GameEventListener;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.*;
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

    public Model getModel() {

        return model;
    }

    public Karakter getActiveKarakter() {

        return activeKarakter;
    }

    public void lep(Mezo mezo){

        model.leptet(activeKarakter, mezo);
    }

    public void as(){

        model.as(activeKarakter);
    }

    public void targyatFelvesz(){

        model.targyatFelvesz(activeKarakter);
    }

    public void iglutEpit(){

        model.iglutEpit((Eszkimo)activeKarakter);
    }

    public void satratEpit(){

        model.satratEpit(activeKarakter);
    }

    public void osszeszerel(){

        model.osszeszerel(activeKarakter);
    }

    //EventHandling
    public void addMezoEventListener(MezoEventListener listener){

        listenerList.add(MezoEventListener.class, listener);
    }


    public void addGameEventListener(GameEventListener listener){

        listenerList.add(GameEventListener.class, listener);
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
                ((MezoEventListener)listeners[i + 1]).leptek(eventObject);
        }
    }

    public void asasEvent(AsasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).astak(eventObject);
        }
    }

    public void eszkimoKepessegEvent(EszkimoKepessegEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).eszkimoKepesseg(eventObject);
        }
    }

    public void kimentesEvent(KimentesEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).kimentettek(eventObject);
        }
    }

    public void kutatoKepessegEvent(KutatoKepessegEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).kutatoKepesseg(eventObject);
        }
    }

    public void targyfelvetelEvent(TargyfelvetelEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).targyfelvetel(eventObject);
        }
    }

    public void targyhasznalatEvent(TargyhasznalatEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).targyhasznalat(eventObject);
        }
    }

    public void viharEvent(ViharEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).vihar(eventObject);
        }
    }

    public void karakterKorvege(KarakterKorvegeEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).karakterKorvege(eventObject);
        }
    }

    public void korvege(KorvegeEvent evventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).korvege(evventObject);
        }
    }

    public void jatekVege(JatekvegeEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).jatekVege(eventObject);
        }
    }

    public void uzenet(UzenetEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).uzenetEvent(eventObject);
        }
    }

    private void addGameEventListener(){

        GameEventListener gameEventListener = new GameEventListener() {

            @Override
            public void karakterKorvege(KarakterKorvegeEvent event) {


            }

            @Override
            public void korvege(KorvegeEvent event) {


            }

            @Override
            public void jatekVege(JatekvegeEvent event) {


            }

            @Override
            public void uzenetEvent(UzenetEvent event) {

            }
        };

        addGameEventListener(gameEventListener);
    }
}
