package Mozgathato;

import Mezo.Mezo;

/**
 * Az eszkimo tipusu karaktert jelkepezi a jatekban.
 * Tobb testhovel indul, mint a kutato, es kepes iglut epiteni.
 */
public class Eszkimo extends Karakter {

    public Eszkimo(Mezo mezo) {

        this.testho = 5;
        this.munka = 4;
        this.mezo = mezo;
    }

    /**
     * Iglut epit a jegtablara amin, all, igy elkerulve a vihar hatasait.
     * atallitja, az ot tartalmazo jegtabla "igluzott" erteket true-ra.
     */
    public void iglutEpit(){}
}
