package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Karakter;
import Mozgathato.Mozgathato;
import Mozgathato.Eszkimo;
import Mozgathato.Kutato;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Jatek;

import java.util.HashMap;
import java.util.List;

public class KarakterCommand extends Command {
    private HashMap<String, Karakter> karakterek;
    private HashMap<String, Mozgathato> mozgathatok;
    HashMap<String, Mezo> mezok;

    public KarakterCommand(HashMap<String, Karakter> karakterek, HashMap<String, Mozgathato> mozgathatok, HashMap<String, Mezo> mezok) {
        this.karakterek = karakterek;
        this.mozgathatok = mozgathatok;
        this.mezok = mezok;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {
        //TODO: tárgyak felvétele

        if(args.length < 3)
            throw new WrongArgumentException("A karakterhez nem volt mezo megadva.");
        if(!mezok.containsKey(args[2]))
            throw new WrongArgumentException("A megadott mezo nem letezik.");
        if(!(args[1].equals("e") || args[1].equals("k")))
            throw new WrongArgumentException("A megadott karaktertipus nem letezik.");

        Karakter karakter = null;
        switch (args[1]){
            case "e": karakter = new Eszkimo(mezok.get(args[2])); break;
            case "k": karakter = new Kutato(mezok.get(args[2])); break;
        }
        karakterek.putIfAbsent(args[1] + args[0], karakter);
        mozgathatok.putIfAbsent(args[1] + args[0], karakter);
    }

    @Override
    public String getName() {
        return "karakter";
    }

    @Override
    protected String usage() {
        return "karakter [azonosito] [tipus] [mezo] [targy1] [targy2]...";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: karakter 1 e m1 kotel aso";
    }

    @Override
    public String getDescription() {
        return "Letrehoz egy karaktert a parameterben megadott " +
               "azonositoval, tipussal a megadott mezon a megadott targyakkal.";
    }
}
