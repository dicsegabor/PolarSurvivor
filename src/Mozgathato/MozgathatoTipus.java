package Mozgathato;

import Mezo.Mezo;
import Proto.Commander.Exceptions.WrongArgumentException;
import Targy.Targy;

import java.util.List;

public enum MozgathatoTipus {

    KUTATO, ESZKIMO, JEGESMEDVE;

    public static Karakter letrehoz(MozgathatoTipus tipus, Mezo mezo) throws WrongArgumentException {

        switch (tipus){

            case KUTATO: return new Kutato(mezo);
            case ESZKIMO: return new Eszkimo(mezo);
            default: throw new WrongArgumentException("Nincs ilyen tipus: " + tipus);
        }
    }

    public static Karakter letrehoz(MozgathatoTipus tipus, Mezo mezo, List<Targy> targyak) throws WrongArgumentException {

        switch (tipus){

            case KUTATO: return new Kutato(mezo, targyak);
            case ESZKIMO: return new Eszkimo(mezo, targyak);
            default: throw new WrongArgumentException("Nincs ilyen tipus: " + tipus);
        }
    }
}
