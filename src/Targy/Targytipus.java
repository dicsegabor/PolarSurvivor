package Targy;

import java.util.Random;

/**
 * Tarolja a targyak tipusait.
 */
public enum Targytipus {

    LAPAT, KOTEL, BUVARRUHA, ELELEM, PISZTOLY, JELZOFENY, PATRON, SATOR, TOREKENYLAPAT;

    public static Targy letrehoz(Targytipus tipus) {

        switch (tipus){

            case LAPAT: return new Lapat();
            case KOTEL: return new Kotel();
            case BUVARRUHA: return new Buvarruha();
            case ELELEM: return new Elelem();
            case PISZTOLY: return new Pisztoly();
            case JELZOFENY: return new Jelzofeny();
            case PATRON: return new Patron();
            case SATOR: return new Sator();
            case TOREKENYLAPAT: return new TorekenyLapat();
        }

        return null;
    }

    public static Targy randomTargy(){

        switch (new Random().nextInt(5)){

            case 0: return new Lapat();
            case 1: return new Kotel();
            case 2: return new Buvarruha();
            case 3: return new Elelem();
            case 4: return new Sator();
            case 5: return new TorekenyLapat();
        }

        return null;
    }
}
