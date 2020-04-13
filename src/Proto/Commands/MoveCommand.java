package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Jatek;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand extends Command {

    private Jatek jatek;

    public MoveCommand(Jatek jatek){

        this.jatek = jatek;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        jatek.lep();
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
