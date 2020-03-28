package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Pisztoly implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Pisztoly.hasznal()");
    }

    @Override
    public void tipus() {}
}
