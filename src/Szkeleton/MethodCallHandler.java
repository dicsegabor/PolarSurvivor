package Szkeleton;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Ez az osztály felel a függvényhívások szép megjelenítéséért.
 */
public class MethodCallHandler {

    private static int indent = 0;
    private static String buffer = "";

    /**
     * A paraméterül kapoot sztringet egy bufferbe írja be.
     * @param methodName Ez fog megjelenni a képernyőn, mint a függvény.
     * @param withInnerMethodCalls Azt jelzi, hogy a meghívott függvényeden belül fogsz-e használni más függvényeket.
     */
    public static void callMethod(String methodName, boolean withInnerMethodCalls){

        for (int i = 0; i < indent; i++)
            buffer += "\t";

        buffer += methodName + "\n";

        if(withInnerMethodCalls)
            innerMethodCalls();
    }

    public static void callMethod(Class from, String methodName){

        Method method = null;
        try { method = from.getMethod(methodName); }
        catch (NoSuchMethodException e) { System.out.println("Nincs ilyen metódus!(" + from.getSimpleName() + "." + methodName + ")"); }

        for (int i = 0; i < indent; i++)
            buffer += "\t";

        buffer += method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()\n";
    }

    public static void callMethod(Class from, String methodName, String parameter){

        Method method = null;
        try { method = from.getMethod(methodName); }
        catch (NoSuchMethodException e) { System.out.println("Nincs ilyen metódus!(" + from.getSimpleName() + "." + methodName + ")"); }

        for (int i = 0; i < indent; i++)
            buffer += "\t";

        buffer += method.getDeclaringClass().getSimpleName() + "." + method.getName() + "(" + parameter + ")\n";
    }

    /**
     * Függvényen belüli függvényhívást "rajzol".
     */
    public static void innerMethodCalls(){

        for (int i = 0; i < indent; i++)
            buffer += "\t";

        buffer += "{\n";
        indent++;
    }

    /**
     * Hívd meg miután egy függvényen belül hívsz függvényeket.
     */
    public static void endOfInnerMethodCalls(){

        indent--;
        for (int i = 0; i < indent; i++)
            buffer += "\t";


        buffer += "}\n";
    }

    /**
     * Lezárja a kapcsos zárójeleket, valamint kiírja a buffer tartalmát a konzolra.
     * Vár a következő leütött billentyűig.
     */
    public static void endScenario(){

        if(buffer.endsWith("{\n")){

            buffer = buffer.substring(0, buffer.length() - 3);
            indent --;
        }

        while (indent-- > 0){

            for (int i = 0; i < indent; i++)
                buffer += "\t";

            buffer += "}\n";
        }

        System.out.print(buffer);
        buffer = "";
        indent = 0;

        waitForKey();
    }

    /**
     * Vár a következő leütött billentyűig.
     */
    private static void waitForKey(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Nyomjon entert a folytatáshoz . . .");
        scan.nextLine();
        clearScreen();
    }

    /**
     * Törli a konzol tartalmát.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
