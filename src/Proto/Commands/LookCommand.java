package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class LookCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        ProtoProgram.megvizsgal(args[0], args[1]);
    }

    @Override
    public String getName() {
        return "look";
    }

    @Override
    protected String usage() {
        return "look [karakter] [mezo]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[karakter]", "A karakter azonositoja, aki megnezi a mezot."));
                add(String.format("%-30s%s", "[mezo]", "A mezo, amit megvizsgal a kutato."));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Pl.: look KUTATO_2 STABIL_2_3";
    }

    @Override
    public String getDescription() {
        return "A parameterul kapott mezorol a kutato megallapitja a mezo kapacitasat.";
    }
}
