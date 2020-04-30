package Proto.LogAndTesting;

import java.io.*;

public class Logger {

    static FileWriter logWriter;
    static public boolean logging = false;

    public Logger(String fileName){

        File logFile = new File(fileName);
        try {
            if (logFile.exists()) {

                logFile.delete();
                logFile.createNewFile();
            }
        }
        catch (Exception ignored) {}

        try { logWriter = new FileWriter(logFile); }
        catch (IOException ignored) { }
    }

    public static void log(){

        if(logging) {
            Throwable t = new Throwable();

            String logMessage = t.getStackTrace()[1].getClassName() + "." + t.getStackTrace()[1].getMethodName() + "\n";

            try {
                logWriter.write(logMessage);
                logWriter.flush();
            } catch (IOException e) {
                System.out.println("Can't write to file!");
            }
        }
    }

    public static void log(String uzenet){

        try {
            logWriter.write(uzenet);
            logWriter.flush();
        } catch (IOException e) {
            System.out.println("Can't write to file!");
        }
    }
}
