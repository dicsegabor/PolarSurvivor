package Proto.Commands;

import Mezo.Mezo;
import Mozgathato.Karakter;
import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Jatek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DigCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        Jatek.as(args[0]);
    }

    @Override
    public String getName() {
        return "dig";
    }

    @Override
    protected String usage() {
        return "dig [karakter]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[karakter]", "A karakter azonositoja, aki as."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: dig KUTATO_1";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott karakter as a mezon, amin all.";
    }
}
