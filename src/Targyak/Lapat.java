package Targyak;

import Mezok.Mezo;
import Szkeleton.Program;

public class Lapat implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Program.writeToBuffer("Lapat.hasznal(){");
        Program.indent++;
        mezo.havatCsokkent(2);
    }

    @Override
    public void tipus() {}
}
