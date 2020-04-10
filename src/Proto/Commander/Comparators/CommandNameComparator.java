package Proto.Commander.Comparators;

import Proto.Commander.Commands.Command;

import java.util.Comparator;

public class CommandNameComparator implements Comparator {

    @Override
    public int compare(Object o, Object t1) {

        return ((Command)o).getName().compareTo(((Command)t1).getName());
    }
}
