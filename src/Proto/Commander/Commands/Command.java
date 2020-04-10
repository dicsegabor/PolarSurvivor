package Proto.Commander.Commands;

import Proto.Commander.Exceptions.WrongArgumentException;

import java.util.List;

/**
 * A konzolban kiadhato parancs "interfesze".
 */
public abstract class Command {

    /**
     * Tartalmazza, amit vegrehajt a parancs kiadaskor.
     * @param args Ebben adodnak at a kiadott parancshoz tartozo argumentumok.
     * @throws WrongArgumentException Ha rossz argumentunot kap a parancs, akkor dob egy ilyen kivetelt,
     * aminek a szovege kiirodik a standard kimenetre.
     */
    abstract public void execute(String[] args) throws WrongArgumentException;

    /**
     * Visszater a parancs nevevel.
     * @return Ide azt kell irni, ahogy a parancsot ki kell adni. (Pl.: exit, help)
     */
    abstract public String getName();

    /**
     * Az absztrakt fuggvenyek alapjan osszeszerkeszti a hasznalati utmutatot.
     * @return A vegeredmenynek valami hasonlonak kell lennie.
     * Hasznalat: parancsnev [argumentum1] [argumentum2] ...\n
     * \n
     * [argumentum1] Argumentum leirasa\n
     * [argumnetum2] Argumentum leirasa\n
     * ...
     * \n
     * Egyeb informaciok.
     */
    public String getHelp(){

        StringBuilder helpString = new StringBuilder("Hasznalat: " + usage());

        if(argumentsHelp() != null) {

            helpString.append("\n\n");

            for (String s : argumentsHelp())
                helpString.append(s).append("\n");
        }

        if(otherInfo() != null)
            helpString.append("\n").append(otherInfo());

        return helpString.toString();
    }

    /**
     * A parancs hasznalatat irja le. A kimenetet az alabbi formatumban kell megirni.
     * @return parancsnev [argumentum1] [argumentum2] ...
     */
    abstract protected String usage();

    /**
     * Az argumentumokhoz tartozo leirast adja meg.
     * A leirasokat sorban hozza kell adni a listahoz, amivelo visszater, az alabbi formatum szerint.
     * @return [argumentum1] Argumentum leirasa
     * Ha nincs hagyd null-on.
     * (Pl.:HelpCommand.argumnetsHelp())
     */
    abstract protected List<String> argumentsHelp();

    /**
     * A parancshoz tartozo egyeb informaciokat tartalmazza.
     * @return Nincs kulonosebb formazasi igeny.
     * Ha nincs hagyd null-on.
     */
    abstract protected String otherInfo();

    /**
     * Szimplan leirja, hogy mit csinal a parancs.
     * @return Lehetoleg roviden, tomoren, egy sorban.
     */
    abstract public String getDescription();
}
