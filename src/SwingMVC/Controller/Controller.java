package SwingMVC.Controller;

import Mezo.Mezo;
import Mozgathato.Eszkimo;
import Mozgathato.Karakter;
import Mozgathato.Kutato;
import SwingMVC.Eventhandling.Eventhandlers.GameEventListener;
import SwingMVC.Eventhandling.Eventhandlers.MezoEventListener;
import SwingMVC.Eventhandling.Events.*;
import SwingMVC.Model.Model;
import SwingMVC.View.GameBoard;

import javax.swing.*;
import javax.swing.event.EventListenerList;

/**
 * Singleton Controller
 * A view és model közti összeköttetést valósítja meg
 */
public class Controller {

    private static Controller instance;
    /**
     * Az játék állapotát tartalmazó Model példány
     */
    private Model model;
    /**
     * A jelenleg soron lévõ karakter modellbeli megfelelõje
     */
    private Karakter activeKarakter;
    /**
     * A view, amit a felhaszáló lát
     */
    private GameBoard gameBoard;
    /**
     * A játék futását jelzõ változó
     */
    private boolean running;
    /**
     * Jelzi, hogy a pályabetöltés random vagy elõre elkészített pályával történjen
     */
    private boolean randomMap;

    /**
     * Az eseményekre feliratkozó EventListenerek listája
     */
    private EventListenerList listenerList;

    /**
     * A Controller példány lekérdezése
     * @return A Controller példány
     */
    public static Controller getInstance() {

        if(instance == null)
            return new Controller();

        return instance;
    }

    /**
     * A Controller singleton inicializálása
     */
    public Controller(){

        instance = this;

        running = true;
        randomMap = false;
        listenerList = new EventListenerList();
        // új model létrehozása
        model = new Model();
        // a soron következõ karakter lekérése a modellbõl
        activeKarakter = model.getKarakter(0);

        // Az eseménykezelõk beregisztrálása
        addGameEventListener();
    }

    /**
     * Az adatokat tartalmazó modell
     * @return A használatban lévõ modell
     */
    public Model getModel() {

        return model;
    }

    /**
     * A jelenleg soron lévõ karakter a modellbõl
     * @return A soron lévõ karakter
     */
    public Karakter getActiveKarakter() {

        return activeKarakter;
    }

    /**
     * Random generált pályát töltsön-e be
     * @param isRandom A random pályabetöltést jelzõ boolean
     */
    public void setMap(boolean isRandom){

        randomMap = isRandom;
    }

    /**
     * Felveszi a view-t képezõ GameBoardot
     * @param gameBoard A megjelenítendõ GameBoard
     */
    public void addGameBoard(GameBoard gameBoard){

        this.gameBoard = gameBoard;
        // soron lévõ karakter kiemelése
        gameBoard.highlightKarakter();
    }

    /**
     * Új játék indítása
     */
    public void restart(){

        running = true;

        if(randomMap)
            model.generateRandomMap();
        else
            model.loadDefaultMap();

        activeKarakter = model.getKarakter(0);
        gameBoard.reset();
        gameBoard.repaint();
        gameBoard.revalidate();
    }

    /**
     *
     * @param mezo  A model a paraméterül kapott mezõre lépteti az aktív karaktert.
     */
    public void lep(Mezo mezo){

        model.lep(activeKarakter, mezo);
    }

    /**
     * Aktív karakter ás
     */
    public void as(){

        model.as(activeKarakter);
    }

    /**
     * Aktív karakter tárgyat felvesz.
     */
    public void targyatFelvesz(){

        model.targyatFelvesz(activeKarakter);
    }

    /**
     * Aktív eszkimo karakter iglut épít
     */
    public void iglutEpit(){

        model.iglutEpit((Eszkimo)activeKarakter);
    }

    /**
     * Aktív karakter sátrat épít.
     */
    public void satratEpit(){

        model.satratEpit(activeKarakter);
    }

    /**
     * összeszereli a karakter a nyeréshez szükséges tárgyakat.
     */
    public void osszeszerel(){

        model.osszeszerel(activeKarakter);
    }

    /**
     * Az aktív sarkkutató karakter a paraméterül kapott mezõt megvizsgálja
     * @param mezo
     */
    public void jegetNez(Mezo mezo){

        model.jegetNez((Kutato) activeKarakter, mezo);
    }

        //EventHandling
    public void addMezoEventListener(MezoEventListener listener){

        listenerList.add(MezoEventListener.class, listener);
    }

    public void addGameEventListener(GameEventListener listener){

        listenerList.add(GameEventListener.class, listener);
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void atfordultEvent(AtfordulasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).atfordult(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void lepesEvent(LepesEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).leptek(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void asasEvent(AsasEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).astak(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void epitesEvent(EpitesEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).epites(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void kutatoKepessegEvent(KutatoKepessegEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).kutatoKepesseg(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void targyfelvetelEvent(TargyfelvetelEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).targyfelvetel(eventObject);
        }
    }

    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void targyhasznalatEvent(TargyhasznalatEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).targyhasznalat(eventObject);
        }
    }
    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */

    public void viharEvent(ViharEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == MezoEventListener.class)
                ((MezoEventListener)listeners[i + 1]).vihar(eventObject);
        }
    }

    /**
     * A függvény értesíti a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void karakterKorvege(KarakterKorvegeEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).karakterKorvege(eventObject);
        }
    }
    /**
     * A függvények értesítik a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */

    public void korvege(KorvegeEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).korvege(eventObject);
        }
    }

    /**
     * A függvények értesítik a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void jatekVege(JatekvegeEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).jatekVege(eventObject);
        }
    }
    /**
     * A függvények értesítik a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void uzenet(UzenetEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).uzenetEvent(eventObject);
        }
    }
    /**
     * A függvények értesítik a listenereket a paraméterben megadott eventrõl.
     * @param eventObject
     */
    public void statusUpdate(KarakterStatusUpdateEvent eventObject){

        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i += 2){

            if(listeners[i] == GameEventListener.class)
                ((GameEventListener)listeners[i + 1]).statusUpdate(eventObject);
        }
    }

    private void addGameEventListener(){

        GameEventListener gameEventListener = new GameEventListener() {

            @Override
            public void karakterKorvege(KarakterKorvegeEvent event) {

                gameBoard.removeHighlightKarakter();
                activeKarakter = model.getNextKarakter(activeKarakter);
                gameBoard.highlightKarakter();

                statusUpdate(new KarakterStatusUpdateEvent(this));
            }

            @Override
            public void korvege(KorvegeEvent event) {}

            @Override
            public void jatekVege(JatekvegeEvent event) {

                if(running) {

                    JOptionPane.showMessageDialog(gameBoard, event.uzenet, "Vége a játéknak", JOptionPane.PLAIN_MESSAGE);
                    running = false;
                    restart();
                }
            }

            @Override
            public void uzenetEvent(UzenetEvent event) {

                JOptionPane.showMessageDialog(gameBoard, event.uzenet, "Üzenet" , JOptionPane.PLAIN_MESSAGE);
            }

            @Override
            public void statusUpdate(KarakterStatusUpdateEvent event) {

                gameBoard.setStatusBarText();
                gameBoard.repaint();
                gameBoard.revalidate();
            }
        };

        addGameEventListener(gameEventListener);
    }
}
