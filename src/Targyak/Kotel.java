package Targyak;

import Karakterek.Karakter;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Program;

public class Kotel implements Targy {

    @Override
    public void hasznal(Mezo mezo) {

        Karakter victim = new Karakter();

        Program.writeToBuffer("Kotel.hasznal(){");
        Program.indent++;
        victim.lep(new StabilJegtabla());
        Program.indent--;
        Program.writeToBuffer("}");
    }

    @Override
    public void tipus() {}
}
