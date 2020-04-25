package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class JegesmedveCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 1)
            throw new WrongArgumentException("A jegesmedvehez nem volt mezo megadva.");

        ProtoProgram.letrehozJegesmedve(args[0]);
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

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[mezo]", "A mezo, amire szeretnenk tenni a jegesmedvet."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: jegesmedve STABIL_1_1";
    }

    @Override
    public String getDescription() {
        return "Letrehoz egy jegesmedvet a parameterul megadott mezore.";
    }
}
