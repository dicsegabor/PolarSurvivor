package Proto.Commander.Commands;

import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.LogAndTesting.Logger;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends Command {

    private List<Command> commands;

    public HelpCommand(List<Command> commands){

        this.commands = commands;
    }

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length == 0) {

            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.print("[Commands]\n");

            for(Command c : commands)
                System.out.print(String.format("%-30s%s%c", c.getName(), c.getDescription(), '\n'));

            System.out.println("-----------------------------------------------------------------------------------------------------");
        }

        else if(args.length == 1) {

            try { writeHelp(args[0]); }
            catch (WrongArgumentException e) { throw new WrongArgumentException(e.getMessage()); }
        }
    }

    private void writeHelp(String cmd) throws WrongArgumentException {

        for (Command c : commands)
            if (c.getName().equals(cmd)) {

                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("[" + c.getName() + "]\n" + c.getDescription() + "\n\n" + c.getHelp());
                System.out.println("-----------------------------------------------------------------------------------------------------");
                return;
            }

        throw new WrongArgumentException("A(z) '" + cmd + "' nevu parancs nem talalhato. " +
                "A parancsok listajanak megtekintesehez, kerjuk hasznalja a help parancsot!");
    }

    @Override
    public String getName() {

        return "help";
    }

    @Override
    protected String usage() {

        return "help [parancs neve]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return new ArrayList<>(){
            {
                add(String.format("%-30s%s", "[parancs neve]", "A kivalasztott parancs, aminek a leirasat szeretne megtekinteni."));
            }
        };
    }

    @Override
    protected String otherInfo() {

        return "Ha argumentumok nelkul hivjuk meg, akkor kilistazza az osszes parancs nevet es leirasat.";
    }

    @Override
    public String getDescription() {

        return "Leirja egy parancs hasznalatat.";
    }
}
