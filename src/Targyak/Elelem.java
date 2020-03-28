package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Elelem implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Elelem.hasznal()");
    }

    @Override
    public void tipus() {}
}
