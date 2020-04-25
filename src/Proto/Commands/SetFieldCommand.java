package Proto.Commands;

import Proto.Commander.Commands.Command;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Jatek;
import Targy.Targy;
import Targy.Targytipus;

import java.util.List;

public class SetFieldCommand extends Command {

    @Override
    public void execute(String[] args) throws WrongArgumentException {

        if(args.length < 2)
            throw new WrongArgumentException("Nincs eleg adat megadva!");

        if(args.length > 4)
            throw new WrongArgumentException("Tul sok adat van megadva!");

        int horeteg;
        try { horeteg = Integer.parseInt(args[1]); }
        catch (IllegalArgumentException e) { throw new WrongArgumentException("A megadott '" + args[1] + "' ertek nem egesz szam!"); }

        if(args[0].matches("STABIL.*")){

            if(args.length == 2)
                Jatek.beallitStabilJegtablat(args[0], horeteg, null);

            else if(args.length == 3)
                Jatek.beallitStabilJegtablat(args[0], horeteg, Targytipus.letrehoz(Targytipus.valueOf(args[2])));

            else
                throw new WrongArgumentException("Tul sok adat van megadva!");
        }

        else if(args[0].matches("INSTABIL.*")){

            if(args.length < 3)
                throw new WrongArgumentException("Nincs eleg adat megadva!");

            int kapacitas;
            try { kapacitas = Integer.parseInt(args[2]); }
            catch (IllegalArgumentException e) { throw new WrongArgumentException("A megadott '" + args[2] + "' ertek nem egesz szam!"); }

            Targy targy;

            if(args.length == 3)
                Jatek.beallitInstabilJegtablat(args[0], horeteg, kapacitas, null);

            if(args.length == 4)
                Jatek.beallitInstabilJegtablat(args[0], horeteg, kapacitas, Targytipus.letrehoz(Targytipus.valueOf(args[3])));

            else
                throw new WrongArgumentException("Tul sok adat van megadva!");
        }

        else
            throw new WrongArgumentException("Nincs ilyen tipusu tabla!");
    }

    @Override
    public String getName() {

        return "setfield";
    }

    @Override
    protected String usage() {

        return "setmezo [mez� azonos�t�] [h�r�teg] [kapacit�s] [t�rgy]";
    }

    @Override
    protected List<String> argumentsHelp() {

        return null;
    }

    @Override
    protected String otherInfo() {

        return "Pl.: setmezo m4 4 3 kotel";
    }

    @Override
    public String getDescription() {
        return "A param�ter�l megadott mez�t ell�tja megfelel� sz�m� h� r�teggel �s kapacit�ssal �s egy t�rggyal.";
    }
}
