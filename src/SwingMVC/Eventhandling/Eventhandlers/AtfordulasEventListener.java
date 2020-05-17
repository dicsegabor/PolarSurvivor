package SwingMVC.Eventhandling.Eventhandlers;

import SwingMVC.Eventhandling.Events.AtfordulasEvent;

import java.util.EventListener;

public interface AtfordulasEventListener extends EventListener {

    void atfordult(AtfordulasEvent event);
}
