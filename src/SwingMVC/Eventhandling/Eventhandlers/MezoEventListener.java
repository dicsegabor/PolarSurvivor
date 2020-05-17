package SwingMVC.Eventhandling.Eventhandlers;

import Mozgathato.*;
import SwingMVC.Eventhandling.Events.AsasEvent;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;
import SwingMVC.Eventhandling.Events.LepesEvent;

import java.util.EventListener;

public interface MezoEventListener extends EventListener {

    void atfordult(AtfordulasEvent event);

    void astak(AsasEvent event);

    void leptek(LepesEvent event, Mozgathato mozgathato);
}
