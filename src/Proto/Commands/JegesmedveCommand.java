package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Jegesmedve;
import Mozgathato.Mozgathato;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.HashMap;
import java.util.List;

public class JegesmedveCommand extends Command {
    private HashMap<String, Mozgathato> mozgathatok;
    HashMap<String, Mezo> mezok;

    public JegesmedveCommand(HashMap<String, Mozgathato> mozgathatok, HashMap<String, Mezo> mezok) {
        this.mozgathatok = mozgathatok;
        this.mezok = mezok;
    }
    @Override
    public void execute(String[] args) throws WrongArgumentException {
        if(args.length < 1)
            throw new WrongArgumentException("A jegesmedvehez nem volt mezo megadva.");
        if(!mezok.containsKey(args[0]))
            throw new WrongArgumentException("A megadott mezo nem letezik.");

        Jegesmedve jegesmedve = new Jegesmedve(mezok.get(args[0]));
        mezok.get(args[0]).befogad(jegesmedve);
        mozgathatok.putIfAbsent("j", jegesmedve);
    }

    @Override
    public String getName() {
        return "jegesmedve";
    }

    @Override
    protected String usage() {
        return "jegesmedve [mezo]";
    }

    @Override
    protected List<String> argumentsHelp() {
        return null;
    }

    @Override
    protected String otherInfo() {
        return "Pl.: jegesmedve m12";
    }

    @Override
    public String getDescription() {
        return "Letrehoz egy jegesmedvet a parameterul megadott mezore.";
    }
}
