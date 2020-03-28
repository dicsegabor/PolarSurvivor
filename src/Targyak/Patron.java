package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Patron implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Patron.hasznal()");
    }

    @Override
    public void tipus() {}
}
