package SwingMVC.Eventhandling.Eventhandlers;

import SwingMVC.Eventhandling.Events.*;

import java.util.EventListener;

/**
 * A játék futása során felmerülõ eventek kezeléséért felelõs.
 * Olyan eventekre kell itt gondolni, amik nem feltétlen a mezõkhöz kötõdenek,
 * hanem inkább a játék egészéhez.
 */
public interface GameEventListener extends EventListener {

    /**
     * A karakter körének a végére figyel, és az ehhez tartozó eventtel hívja meg.
     * @param event A kör végéhez tartozó event
     */
    void karakterKorvege(KarakterKorvegeEvent event);

    /**
     * Az összes karakter körének a végére figyel, és az ehhez tartozó eventtel hívja meg.
     * @param event A összes karakter körének végéhez tartozó event
     */
    void korvege(KorvegeEvent event);

    /**
     * A játék végére figyel, és az ehhez tartozó eventtel hívja meg.
     * @param event A játék végéhez tartozó event
     */
    void jatekVege(JatekvegeEvent event);

    /**
     * Ezen keresztül lehet üzenentet küldeni a felhasználónak
     * @param event UzenetEvent
     */
    void uzenetEvent(UzenetEvent event);

    /**
     * A karakter állapotvaáltozására figyel
     * @param event KarakterStatusUpdateEvent
     */
    void statusUpdate(KarakterStatusUpdateEvent event);
}
