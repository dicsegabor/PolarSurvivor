package SwingMVC.Eventhandling.Eventhandlers;

import SwingMVC.Eventhandling.Events.*;

import java.util.EventListener;

public interface GameEventListener extends EventListener {

    void karakterKorvege(KarakterKorvegeEvent event);

    void korvege(KorvegeEvent event);

    void jatekVege(JatekvegeEvent event);

    void uzenetEvent(UzenetEvent event);

    void statusUpdate(KarakterStatusUpdateEvent event);
}
