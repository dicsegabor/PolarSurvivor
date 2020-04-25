package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.ArrayList;
import java.util.List;

public class MoveCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {
        
        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg megadott adat!");

        ProtoProgram.lep(args[0], args[1]);
    }

    @Override
    public String getName() {
        return "move";
    }

    @Override
    protected String usage() {
        return "move [mozgathato] [mezo]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[mozgathato]", "Barmilyen mozgathato dolognak az azonositoja."));
                add(String.format("%-30s%s", "[mezo]", "A mezo azonositoja, ahova mozgatni szeretnenk."));
            }
        };
    }

    @Override
    protected String otherInfo() {
        return "Pl.: move KUTATO_1 STABIL_1_1";
    }

    @Override
    public String getDescription() {

        return "A parameterben megadott karaktert/jegesmedvet a megadott mezore lepteti.";
    }
}
