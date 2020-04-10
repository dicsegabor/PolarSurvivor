package Proto.Commander.Commands;

import Proto.Commander.Commander;
import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.List;

public class ExitCommand extends Command {

    Commander commander;

    public ExitCommand(Commander commander){

        this.commander = commander;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length == 0)
            commander.stop();

        else
            throw new WrongArgumentException("Ennek a parancsnak nincsenek argumentumai!");
    }

    @Override
    public String getName() {

        return "exit";
    }

    @Override
    protected String usage() {

        return "exit";
    }

    @Override
    protected List<String> argumentsHelp() {

        return null;
    }

    @Override
    protected String otherInfo() {

        return null;
    }

    @Override
    public String getDescription() {

        return "Bezarja a programot.";
    }
}
