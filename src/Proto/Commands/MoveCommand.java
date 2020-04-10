package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Exceptions.WrongArgumentException;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        //TODO: Megvalositani a funkciot
    }

    @Override
    public String getName() {
        return "move";
    }

    @Override
    protected String usage() {
        return "move [mozgathato azonosito] [mezo azonosito]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[mozgathato azonosito]", "Barmilyen mozgathato dolognak az azonositoja. Pl.: karakter, jegesmedve."));
                add(String.format("%-30s%s", "[mezo azonosito]", "A mezo azonositoja, ahova mozgatni szeretnenk."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: move k1 m1";
    }

    @Override
    public String getDescription() {

        return "A parameterben megadott karaktert/jegesmedvet a megadott mezore lepteti.";
    }
}
