package Proto.LogAndTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class LogTester {

    private Scanner log;

    private HashMap<String, Integer> expected;
    private HashMap<String, Integer> unexpected;

    public LogTester(String fileName) throws FileNotFoundException {

        log = new Scanner(new FileInputStream(fileName));
    }

    private HashMap<String, Integer> createHashMap(List<String> list){

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String s : list)
            hashMap.put(s, 0);

        return hashMap;
    }

    private boolean testHashMap(HashMap<String, Integer> hashMap, String string){

        boolean found = false;

        for(Map.Entry<String, Integer> e : hashMap.entrySet())
            if(e.getKey().matches(string)) {

                e.setValue(e.getValue() + 1);
                found = true;
            }

        return found;
    }

    private void writeErrors(){

        System.out.println("Expected, but not found:");

        for(Map.Entry<String, Integer> e : expected.entrySet())
            if(e.getValue() == 0)
                System.out.println(e.getKey());

        System.out.println("\nFound, but not expected:");

        for(Map.Entry<String, Integer> e : unexpected.entrySet())
            if(e.getValue() != 0)
                System.out.println(e.getKey() + " | Quantity: " + e.getValue());

        System.out.println("");
    }

    public boolean testLog(List<String> expectedLogs, List<String> unexpectedLogs){

        boolean success = true;

        expected = createHashMap(expectedLogs);

        unexpected = createHashMap(unexpectedLogs);

        while (log.hasNext()){

            String testedLine = log.nextLine();

            testHashMap(expected, testedLine);

            if(testHashMap(unexpected, testedLine))
                success = false;
        }

        for(Map.Entry<String, Integer> e : expected.entrySet())
            if (e.getValue() == 0) {

                success = false;
                break;
            }

        System.out.println("                        Test result");
        if(success)
            System.out.println("Test OK!");

        else
            writeErrors();

        return success;
    }
}
