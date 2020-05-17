package SwingMVC.Eventhandling.Eventhandlers;

import Mozgathato.*;
import SwingMVC.Eventhandling.Events.*;

import java.util.EventListener;

public interface MezoEventListener extends EventListener {

    void atfordult(AtfordulasEvent event);

    void astak(AsasEvent event);

    void eszkimoKepesseg(EszkimoKepessegEvent event);

    void kimentettek(KimentesEvent event);

    void kutatoKepesseg(KutatoKepessegEvent event);

    void leptek(LepesEvent event, Mozgathato mozgathato);

    void targyfelvetel(TargyfelvetelEvent event);

    void vihar(ViharEvent event);

    void targyhasznalat(TargyhasznalatEvent event);
}
