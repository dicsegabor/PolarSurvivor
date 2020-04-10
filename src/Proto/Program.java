package Proto;

import Proto.Commander.Commander;
import Proto.Commands.LoadMapCommand;
import Proto.Commands.MoveCommand;

import java.io.FileNotFoundException;

public class Program {

    public static void main(String[] args) throws FileNotFoundException {

        Commander commander = new Commander();
        commander.addCommand(new MoveCommand());
        commander.addCommand(new LoadMapCommand());
        commander.listen(System.in);

    }
}
