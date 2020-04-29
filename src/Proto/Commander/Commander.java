package Proto.Commander;

import Proto.Commander.Commands.*;
import Proto.Commander.Comparators.CommandNameComparator;
import Proto.Commander.Exceptions.*;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ez az osztaly felelos a parancsok beolvasasaert es feldolgozasaert.
 * Kezdetben ket alapveto paranccsal rendelkezik, azonban ezt a keszletet lehet boviteni.
 */
public class Commander {

    public boolean exitOnMistake;

    /**
     * Ezt az attributumot allitva allitjuk le a figyelest.
     */
    private boolean endOfListening;

    /**
     * Ebben a listaban tarolja a parancsokat.
     */
    public final List<Command> commands = new ArrayList<>();

    /**
     * A konstruktorban az osztaly betolti a ket alapveto parancsat.
     */
    public Commander(){

        exitOnMistake = false;
        commands.add(new ExitCommand(this));
        commands.add(new HelpCommand(commands));
    }

    /**
     * A beolvasast vegrehajto fuggveny, ezt hivjuk meg kivulrol a program indulasahoz.
     * Addig olvas be, amig ki nem lepunk a programbol.
     * A beolvasott sort feldarabolja space-ek alapjan,
     * valamint kiszuri az ures enter-eket, tab-okat es space-eket.
     * @param is Bemenetnek megadhato Pl.: standard bemenet, .txt(FileInputStream).
     */
    public void listen(InputStream is) {

        System.out.println("A parancsok listájának megtekintéséhez kérem használja a 'help' parancsot!");

        endOfListening = false;

        Scanner scanner = new Scanner(is);

        while(!endOfListening) {

            String[] fullCmd = formatInput(scanner.nextLine());

            processCommand(fullCmd);
        }
    }

    /**
     * Magikus regexel felbontja a kapott sort argumentumokra.
     * Ha valamit ket " koze teszel, akkor azt egynek veszi.
     * @param line A beolvasott sor, amit kap.
     * @return Visszater a felbontott sorral.
     */
    private String[] formatInput(String line) {

        List<String> fullCmd = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\"[^\"]*\")|([^\" ]*)");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find())
            if(!matcher.group().trim().isBlank()){

                if(matcher.group().trim().startsWith("\""))
                    fullCmd.add(matcher.group().trim().substring(1, matcher.group().trim().length() - 1));

                else
                    fullCmd.add(matcher.group().trim());
            }

        return fullCmd.toArray(String[]::new);
    }

    /**
     * Leallitja a figyelest.
     */
    public void stop(){

        endOfListening = true;
    }

    /**
     * Ez a fuggveny felel a parancs feldolgozasaert.
     * Feldarabolja a kapott parancsot, majd az igy kapott adatokat atadja a vegrehajto fuggvenynek.
     * @param fullCmd A feldarabolt sor, amit beolvastunk a bemenetrol.
     */
    private void processCommand(String[] fullCmd){

        if(fullCmd == null || fullCmd.length == 0)
            return;

        String cmd = fullCmd[0];
        String[] args = new String[fullCmd.length - 1];
        System.arraycopy(fullCmd, 1, args, 0, fullCmd.length - 1);

        try { executeCommand(cmd, args); }
        catch (CommandNotFoundException e) {

            System.out.println("A(z) '" + e.getMessage() + "' nevu parancs nem talalhato. " +
                    "A parancsok listajanak megtekintesehez, kerjuk hasznalja a help parancsot!");

            if(exitOnMistake)
                System.exit(1);
        }
        catch (WrongArgumentException e) {

            System.out.println(e.getMessage());

            if(exitOnMistake)
                System.exit(1);
        }
    }

    /**
     * Ez a fuggveny hajtja vegre a kapott parancsot.
     * @param cmd A kapott parancs neve.
     * @param args A kapott parancs argumentumai.
     * @throws CommandNotFoundException Ilyen kivetelt dob, ha nem talalja a megadott nevu parancsot.
     * @throws WrongArgumentException Ilyen kivetelt dob, ha a megadott parancs argumentumai helytelenek.
     */
   private void executeCommand(String cmd, String[] args) throws CommandNotFoundException, WrongArgumentException {

        for(Command c : commands)
            if(c.getName().equals(cmd)) {

                c.execute(args);
                return;
            }

        throw new CommandNotFoundException(cmd);
   }

    /**
     * Ennek a fuggvenynek a segitsegevel tudjuk uj parancsokkal boviteni a parancslistat.
     * Afuggveny nev szerint sorba rendezi a parancsokat.
     * @param command A listaba beirando parancs.
     */
   public void addCommand(Command command) {

        commands.add(command);
        commands.sort(new CommandNameComparator());
   }
}
