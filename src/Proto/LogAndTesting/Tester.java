package Proto.LogAndTesting;

import Proto.Commander.Commander;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Tester {

    private FileInputStream testFile;
    private String fileName;
    private InputStream commands;
    private Logger logger;
    private LogTester logTester;
    private Commander commander;
    private List<String> expected;
    private List<String> unexpected;

    public Tester(String fileName, Commander commander){

        this.fileName = fileName;

        this.commander = commander;
        try { testFile = new FileInputStream(fileName); }
        catch (FileNotFoundException e) { System.out.println("File '" + fileName + "' does not exist!"); System.exit(1); }

        String simpleFileName = fileName.substring(0, fileName.length() - 4) + "Log.txt";
        logger = new Logger(simpleFileName);
        Logger.logging = true;
        try{ logTester = new LogTester(simpleFileName); }
        catch (FileNotFoundException e) { System.out.println("File '" + simpleFileName + "' does not exist!"); System.exit(1); }

        expected = new ArrayList<>();
        unexpected = new ArrayList<>();
    }

    public void runTest(){

        if(getTestArguments()){

            System.out.println("/////////////////////// Starting test: " + fileName + " ///////////////////////");
            commander.listen(commands);
            boolean success = logTester.testLog(expected, unexpected);
            System.out.println("/////////////////////// End of test: " + fileName + " ///////////////////////");

            if(success)
                System.exit(0);

            else
                System.exit(1);
        }
    }

    private boolean getTestArguments(){

        Scanner scanner = new Scanner(testFile);

        if(scanner.hasNext()){

            if(scanner.nextLine().matches("Expected"))
                expected.addAll(Arrays.asList(scanner.nextLine().split(", ")));

            if(scanner.nextLine().matches("Unexpected"))
                unexpected.addAll(Arrays.asList(scanner.nextLine().split(", ")));

            if(scanner.nextLine().matches("Commands")) {

                StringBuilder sb = new StringBuilder();

                while (scanner.hasNext())
                    sb.append(scanner.nextLine()).append("\n");

                if(sb.toString().matches(".*exit.*")){

                    System.out.println("You forgot to exit! Please write an exit command at the end!");
                    return false;
                }

                commands = new ByteArrayInputStream(sb.toString().getBytes());
            }
        }

        else {

            System.out.println("The test file is empty!");
            return false;
        }

        if(expected.isEmpty()) {

            System.out.println("Invalid test! There are no expected strings!");
            return false;
        }
        if(unexpected.isEmpty()){

            System.out.println("Invalid test! There are no unexpected strings!");
            return false;
        }

        return true;
    }
}
