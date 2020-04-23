package Skeleton;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Ez az osztaly felel a fuggvenyhivasok szep megjeleniteseert.
 */
public class MethodCallHandler {

    private static int indent = 0;
    private static String buffer = "";

    /**
     * Ez a fuggveny kiirja a konzolra a fuggveny nevet es az ot megvalosito osztaly nevet ponttal elvalasztva.
     * @param from Az osztaly, amiben megtalalhato a fuggveny
     * @param methodName A fuggveny neve
     */
    public static void callMethod(Class from, String methodName){

        Method method = null;

        Method[] methods = from.getMethods();

        for(Method m : methods){
            if(m.getName().equals(methodName))
                method = m;
        }

        if(method != null) {

            for (int i = 0; i < indent; i++)
                buffer += "\t";

            buffer += method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()\n";
        }

        else
            System.out.println("Nincs ilyen metodus!(" + from.getSimpleName() + "." + methodName + ")");
    }

    /**
     * Ez a fuggveny kiirja a konzolra a fuggveny nevet es az ot megvalosito osztaly nevet ponttal elvalasztva
     * es a fuggvenynek lehet egy parametert adni.
     * @param from Az osztaly, amiben megtalalhato a fuggveny
     * @param methodName A fuggveny neve
     * @param parameter A fuggveny parametere
     */
    public static void callMethod(Class from, String methodName, String parameter){

        Method method = null;

        Method[] methods = from.getMethods();

        for(Method m : methods){
            if(m.getName().equals(methodName))
                method = m;
        }

        if(method != null) {

            for (int i = 0; i < indent; i++)
                buffer += "\t";

            buffer += method.getDeclaringClass().getSimpleName() + "." + method.getName() + "(" + parameter + ")\n";
        }

        else
            System.out.println("Nincs ilyen metodus!(" + from.getSimpleName() + "." + methodName + ")");
    }

    /**
     * Hivd meg mielott egy fuggvenyen belul hivsz fuggvenyeket.
     */
    public static void innerMethodCalls(){

        for (int i = 0; i < indent; i++)
            buffer += "\t";

        buffer += "{\n";
        indent++;
    }

    /**
     * Hivd meg miutan egy fuggvenyen belul hivsz fuggvenyeket.
     */
    public static void endOfInnerMethodCalls(){

        indent--;
        for (int i = 0; i < indent; i++)
            buffer += "\t";


        buffer += "}\n";
    }

    /**
     * Lezarja a kapcsos zarojeleket, valamint kiirja a buffer tartalmat a konzolra.
     * Var a kovetkezo leutott billentyuig.
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
     * Var a kovetkezo leutott billentyuig.
     */
    private static void waitForKey(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Nyomjon entert a folytatashoz . . .");
        scan.nextLine();
        clearScreen();
    }

    /**
     * Torli a konzol tartalmat.
     */
    public static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else
                Runtime.getRuntime().exec("clear");
        }

        catch (InterruptedException | IOException ignored) {}
    }
}
