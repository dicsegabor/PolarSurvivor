package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.ProtoProgram;

import java.util.List;

public class TurnCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length > 0)
            throw new WrongArgumentException("Ennek a parancsnak nincsenek argumentumai!");

        ProtoProgram.kor();
    }

    @Override
    public String getName() {
        return "turn";
    }

    @Override
    protected String usage() {
        return "turn";
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
        return "Veget er egy kor a jatekban. Vihar lesz, lep egyet a jegesmedve," +
                "valamint mindenki munkaja feltoltodik.";
    }
}
